-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-01-2018 a las 21:45:00
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coltime`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ActualizarProductoPorMinuto` (IN `detalle` INT, IN `negocio` INT, IN `lector` INT, IN `tiempo` VARCHAR(20))  NO SQL
BEGIN
#Formato estándar
IF negocio=1 THEN

UPDATE detalle_formato_estandar d SET d.tiempo_por_unidad=tiempo WHERE d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=lector;

ELSE
 IF negocio=2 THEN
 #Teclados
 
 UPDATE detalle_teclados d SET d.tiempo_por_unidad=tiempo WHERE d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=lector;
 
 ELSE
 #Ensamble
 
 UPDATE detalle_ensamble d SET d.tiempo_por_unidad=tiempo WHERE d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=lector;
 
 END IF;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ActualizarTiempoTotalPorUnidad` (IN `detalle` INT, IN `tiempo` VARCHAR(20))  NO SQL
UPDATE detalle_proyecto dp SET dp.Total_timepo_Unidad=tiempo WHERE dp.idDetalle_proyecto=detalle$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ActualizarTiempoTotalProducto` (IN `detalle` INT, IN `cadena` VARCHAR(20))  NO SQL
BEGIN

UPDATE detalle_proyecto dp SET dp.tiempo_total=cadena WHERE dp.idDetalle_proyecto=detalle;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CalcularTiempoMinutos` (IN `orden` INT, IN `detalle` INT, IN `lector` INT, IN `busqueda` INT)  NO SQL
BEGIN
DECLARE id int;

IF busqueda=1 THEN

SET id=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector);

 UPDATE detalle_formato_estandar f SET  f.hora_terminacion=CURRENT_TIME WHERE f.idDetalle_formato_estandar=id;

SELECT f.tiempo_total_por_proceso,TIME_FORMAT(TIMEDIFF(TIME_FORMAT(f.hora_terminacion,'%H:%i:%s'),TIME_FORMAT(f.hora_ejecucion,'%H:%i:%s')),'%H:%i:%s') as diferencia from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4;


ELSE
 IF busqueda=2 THEN
 
SET id=(SELECT f.idDetalle_teclados from detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector);

 UPDATE detalle_teclados f SET  f.hora_terminacion=CURRENT_TIME WHERE f.idDetalle_teclados=id;

SELECT f.tiempo_total_proceso,TIME_FORMAT(TIMEDIFF(TIME_FORMAT(f.hora_terminacion,'%H:%i:%s'),TIME_FORMAT(f.hora_ejecucion,'%H:%i:%s')),'%H:%i:%s') as diferencia from detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4;

 ELSE
  IF busqueda=3 THEN
  
  SET id=(SELECT f.idDetalle_ensamble from detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector);

 UPDATE detalle_ensamble f SET  f.hora_terminacion=CURRENT_TIME WHERE f.idDetalle_ensamble=id;
  
  SELECT f.tiempo_total_por_proceso,TIME_FORMAT(TIMEDIFF(TIME_FORMAT(f.hora_terminacion,'%H:%i:%s'),TIME_FORMAT(f.hora_ejecucion,'%H:%i:%s')),'%H:%i:%s') as diferencia from detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4;
  
  END IF;
 
 END IF;

END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CambiarEstadoDeProductos` (IN `negocio` INT, IN `detalle` INT)  NO SQL
BEGIN
DECLARE iniciar int;
DECLARE pausar int;
DECLARE terminar int;
DECLARE ejecucion int;
#DECLARE tipoN int;
#Inicializar variables
SET iniciar=(SELECT d.pro_porIniciar FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);
SET pausar=(SELECT d.pro_Pausado FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);
SET ejecucion=(SELECT d.pro_Ejecucion FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);
SET terminar=(SELECT d.pro_Terminado FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);
#SELECT iniciar,pausar,ejecucion,terminar;

IF negocio=1 OR negocio=4 THEN 
#SET tipoN = (SELECT d.tipo_negocio_idtipo_negocio FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);

#Por iniciar
IF iniciar!=0 AND pausar=0 AND ejecucion=0 and terminar=0 THEN
  UPDATE detalle_proyecto d SET d.estado_idestado=1 WHERE d.idDetalle_proyecto=detalle;
ELSE
#Ejecucion
 IF ejecucion>=1 THEN
  UPDATE detalle_proyecto d SET d.estado_idestado=4 WHERE d.idDetalle_proyecto=detalle;
 ELSE
 #Pausado
  IF pausar!=0 and ejecucion=0 and (terminar=0 or terminar!=0) THEN
  UPDATE detalle_proyecto d SET d.estado_idestado=2 WHERE d.idDetalle_proyecto=detalle; 
  ELSE
   IF pausar=0 and ejecucion=0 and terminar!=0 AND iniciar!=0 THEN
   UPDATE detalle_proyecto d SET d.estado_idestado=2 WHERE d.idDetalle_proyecto=detalle;
   ELSE
    #Terminado
    IF (iniciar+pausar+ejecucion+terminar)=terminar AND iniciar=0 AND pausar=0 and ejecucion=0 THEN
  UPDATE detalle_proyecto d SET d.estado_idestado=3 WHERE d.idDetalle_proyecto=detalle;  
    END IF;
   END IF;
  END IF;
 END IF;
END IF;  
 

ELSE
 IF negocio=2 or negocio=3 THEN

  IF iniciar!=0 AND pausar=0 AND ejecucion=0 and terminar=0 THEN
  UPDATE detalle_proyecto d SET d.estado_idestado=1 WHERE d.idDetalle_proyecto=detalle;
  END IF;


IF ejecucion >= 1  THEN
UPDATE detalle_proyecto d SET d.estado_idestado=4 WHERE d.idDetalle_proyecto=detalle;
ELSE
 IF pausar!=0 and ejecucion=0 and (terminar!=0 or terminar=0) THEN
    UPDATE detalle_proyecto d SET d.estado_idestado=2 WHERE d.idDetalle_proyecto=detalle;
 ELSE
  IF terminar!=0 AND ejecucion=0 AND pausar=0 THEN
        CALL PA_CambiarEstadoTerminadoTEIN(negocio,detalle);
   END IF;
 END IF;
END IF;

 END IF;
END IF;

CALL PA_CambiarEstadoDeProyecto((SELECT d.proyecto_numero_orden FROM detalle_proyecto d where d.idDetalle_proyecto=detalle));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CambiarEstadoDeProyecto` (IN `orden` INT)  NO SQL
BEGIN

DECLARE iniciar int;
DECLARE pausar int;
DECLARE ejecucion int;
DECLARE terminado int;

SET iniciar=(SELECT COUNT(*) FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.estado_idestado=1);
SET pausar=(SELECT COUNT(*) FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.estado_idestado=2);
SET terminado=(SELECT COUNT(*) FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.estado_idestado=3);
SET ejecucion=(SELECT COUNT(*) FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.estado_idestado=4);
#SELECT iniciar,pausar,terminado,ejecucion; 
 

#Por iniciar
IF iniciar!=0 AND pausar=0 AND ejecucion=0 and terminado=0 THEN
  UPDATE proyecto p SET p.estado_idestado=1, p.fecha_salidal=null WHERE p.numero_orden = orden;
ELSE
#Ejecucion
 IF ejecucion>=1 THEN
  UPDATE proyecto p SET p.estado_idestado=4, p.fecha_salidal=null WHERE p.numero_orden = orden;
 ELSE
 #Pausado
  IF pausar!=0 and ejecucion=0 and (terminado=0 or terminado!=0) THEN
  UPDATE proyecto p SET p.estado_idestado=2, p.fecha_salidal=null WHERE p.numero_orden = orden;   
  ELSE
   IF pausar=0 and ejecucion=0 and terminado!=0 AND iniciar!=0 THEN
   UPDATE proyecto p SET p.estado_idestado=2, p.fecha_salidal=null WHERE p.numero_orden = orden;  
   ELSE
    #Terminado
    IF (iniciar+pausar+ejecucion+terminado)=terminado AND iniciar=0 AND pausar=0 and ejecucion=0 THEN
  	UPDATE proyecto p SET p.estado_idestado=3, p.fecha_salidal=(SELECT NOW()) WHERE p.numero_orden = orden; 
    END IF;
   END IF;
  END IF;
 END IF;
END IF; 


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CambiarEstadoTerminadoTEIN` (IN `negocio` INT, IN `detalle` INT)  NO SQL
BEGIN
DECLARE res boolean;
IF negocio=2 THEN
  IF EXISTS(SELECT d.estado_idestado FROM detalle_teclados d where    d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=14 AND d.estado_idestado=3) THEN

 SET res= true;
 
 ELSE 

 SET res = false;

 END IF;

ELSE 
  IF negocio=3 THEN
 IF EXISTS(SELECT d.estado_idestado FROM detalle_ensamble d where    d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=18 AND d.estado_idestado=3) THEN

 SET res= true;
 
 ELSE 

 SET res = false;
  
  END IF;
  
 END IF;
END IF;


IF res THEN

 UPDATE detalle_proyecto p SET p.estado_idestado=3  where p.idDetalle_proyecto=detalle;
ELSE
  UPDATE detalle_proyecto p SET p.estado_idestado=2 where p.idDetalle_proyecto=detalle;

END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CantidadProyectosEjecucion` ()  NO SQL
BEGIN

SELECT COUNT(*),dp.negocio_idnegocio FROM detalle_proyecto dp JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE dp.estado_idestado=4 AND dp.PNC=0 and p.eliminacion=1 GROUP BY dp.negocio_idnegocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CantidadProyectosIngresadosArea` ()  NO SQL
BEGIN

SELECT COUNT(dp.idDetalle_proyecto) as catidadIngresada ,dp.negocio_idnegocio FROM detalle_proyecto dp JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE DATE_FORMAT(p.fecha_ingreso,'%Y -%m -%d')=DATE_FORMAT(CURDATE(),'%Y -%m -%d')  and p.eliminacion=1 GROUP BY dp.negocio_idnegocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CantidadProyectosPorIniciar` ()  NO SQL
BEGIN

SELECT COUNT(*),dp.negocio_idnegocio FROM detalle_proyecto dp JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE dp.estado_idestado=1 AND dp.PNC=0 and p.eliminacion=1 GROUP BY dp.negocio_idnegocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CantidadProyectosterminadosHoy` ()  NO SQL
BEGIN
DECLARE FE INT;
DECLARE TE INT;
DECLARE EN INT;
DECLARE AL INT;

SET FE =(SELECT COUNT(*) FROM detalle_formato_estandar df JOIN detalle_proyecto dp ON df.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE DATE_FORMAT(df.fecha_fin,'%Y-%m-%d')=DATE_FORMAT(CURRENT_DATE,'%Y-%m-%d') AND df.Procesos_idproceso=10 AND dp.estado_idestado=3 AND df.estado_idestado=3 and p.eliminacion=1);

SET TE =(SELECT COUNT(*) FROM detalle_teclados dt JOIN detalle_proyecto dp ON dt.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE DATE_FORMAT(dt.fecha_fin,'%Y-%m-%d')=DATE_FORMAT(CURRENT_DATE,'%Y-%m-%d') AND dt.Procesos_idproceso=14 AND dp.estado_idestado=3 AND dt.estado_idestado=3 and p.eliminacion=1);

SET EN =(SELECT COUNT(*) FROM detalle_ensamble de JOIN detalle_proyecto dp ON de.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE DATE_FORMAT(de.fecha_fin,'%Y-%m-%d')=DATE_FORMAT(CURRENT_DATE,'%Y-%m-%d') AND de.Procesos_idproceso=18 AND dp.estado_idestado=3 AND de.estado_idestado=3 and p.eliminacion=1);

SET AL =(SELECT COUNT(*) FROM almacen de JOIN detalle_proyecto dp ON de.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE DATE_FORMAT(de.fecha_fin,'%Y-%m-%d')=DATE_FORMAT(CURRENT_DATE,'%Y-%m-%d') AND dp.estado_idestado=3 AND de.estado_idestado=3 and p.eliminacion=1);

SELECT FE,TE,EN,AL;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarDetalleProyecto` (IN `orden` INT(11), IN `estado` INT)  NO SQL
BEGIN

IF estado=0 THEN
#Desactivados
SELECT d.idDetalle_proyecto,n.nom_negocio,t.nombre,d.canitadad_total,e.nombre as estado, d.PNC,d.ubicacion,d.material,p.parada FROM tipo_negocio t  JOIN detalle_proyecto d on t.idtipo_negocio=d.tipo_negocio_idtipo_negocio JOIN negocio n on d.negocio_idnegocio=n.idnegocio JOIN estado e on d.estado_idestado=e.idestado JOIN proyecto p ON d.proyecto_numero_orden=p.numero_orden WHERE d.proyecto_numero_orden=orden;
ELSE
SELECT d.idDetalle_proyecto,n.nom_negocio,t.nombre,d.canitadad_total,e.nombre as estado, d.PNC,d.ubicacion,d.material,p.parada FROM tipo_negocio t  JOIN detalle_proyecto d on t.idtipo_negocio=d.tipo_negocio_idtipo_negocio JOIN negocio n on d.negocio_idnegocio=n.idnegocio JOIN estado e on d.estado_idestado=e.idestado JOIN proyecto p ON d.proyecto_numero_orden=p.numero_orden WHERE d.proyecto_numero_orden=orden and p.eliminacion=1;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarIndormacionQR` (IN `orden` INT)  NO SQL
BEGIN
select p.idDetalle_proyecto,d.idDetalle_formato_estandar,d.Procesos_idproceso from detalle_proyecto p INNER JOIN detalle_formato_estandar d ON p.idDetalle_proyecto=d.detalle_proyecto_idDetalle_proyecto where p.proyecto_numero_orden=orden;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarNumeroOrden` ()  NO SQL
SHOW TABLE STATUS like 'proyecto'$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarProcesosFE` (IN `detalle` INT)  NO SQL
begin

SELECT p.nombre_proceso FROM detalle_formato_estandar f JOIN procesos p on f.Procesos_idproceso=p.idproceso WHERE f.detalle_proyecto_idDetalle_proyecto=detalle;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarProyectosEliminados` ()  NO SQL
BEGIN

SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.eliminacion=0;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarProyectosEntrega` (IN `orden` INT, IN `nombreC` VARCHAR(45), IN `nombreP` VARCHAR(45), IN `fecha` VARCHAR(10))  NO SQL
BEGIN

IF orden='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.eliminacion=1;
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.eliminacion=1;
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.eliminacion=1;
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.eliminacion=1;
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') and 
p.eliminacion=1;
              ELSE 
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha AND p.eliminacion=1;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha AND p.eliminacion=1;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha AND p.eliminacion=1;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha AND p.eliminacion=1;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha AND p.eliminacion=1;                                   
                                   END IF;
                                 END IF;
                               END IF;
                            END IF;
                         END IF;
                      END IF;
                    END IF;
                  END IF;
                END IF;
              END IF;
            END IF;
         END IF;
      END IF; 
    END IF;
  END IF;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarProyectosIngreso` (IN `orden` INT, IN `nombreC` VARCHAR(45), IN `nombreP` VARCHAR(45), IN `fecha` VARCHAR(10))  NO SQL
BEGIN 

IF orden='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.eliminacion=1; 
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.eliminacion=1;
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.eliminacion=1;
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.eliminacion=1;
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
              ELSE
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha AND p.eliminacion=1;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha AND p.eliminacion=1;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha AND p.eliminacion=1;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha AND p.eliminacion=1;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha AND p.eliminacion=1;                                   
                                   END IF;
                                 END IF;
                               END IF;
                            END IF;
                         END IF;
                      END IF;
                    END IF;
                  END IF;
                END IF;
              END IF;
            END IF;
         END IF;
      END IF; 
    END IF;
  END IF;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarProyectosSalida` (IN `orden` INT, IN `nombreC` VARCHAR(45), IN `nombreP` VARCHAR(45), IN `fecha` VARCHAR(10))  NO SQL
BEGIN

IF orden='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.eliminacion=1;
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.eliminacion=1;
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.eliminacion=1;
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.eliminacion=1;
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
              ELSE
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND p.eliminacion=1;
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha AND p.eliminacion=1;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha AND p.eliminacion=1;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha AND p.eliminacion=1;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha AND p.eliminacion=1;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha AND p.eliminacion=1;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP,p.parada,p.entregaCircuitoFEoGF,p.entregaCOMCircuito,p.entregaPCBFEoGF,p.entregaPCBCom FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha AND p.eliminacion=1;                                   
                                   END IF;
                                 END IF;
                               END IF;
                            END IF;
                         END IF;
                      END IF;
                    END IF;
                  END IF;
                END IF;
              END IF;
            END IF;
         END IF;
      END IF; 
    END IF;
  END IF;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarUsuarios` (IN `doc` VARCHAR(13), IN `nombreApe` VARCHAR(50), IN `cargo` TINYINT)  NO SQL
IF doc='' AND nombreApe='' and cargo=0 THEN
SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado,u.recuperacion FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo;
ELSE
  IF doc!='' AND nombreApe='' and cargo=0 THEN
	SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado,u.recuperacion FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.numero_documento LIKE CONCAT(doc, '%');
 ELSE
     IF doc='' AND nombreApe!='' and cargo=0 THEN 
	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado,u.recuperacion FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.nombres like CONCAT('%', nombreApe, '%') or u.apellidos like CONCAT('%', nombreApe, '%');
     ELSE
        IF doc='' AND nombreApe='' and cargo!=0 THEN
        	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado,u.recuperacion FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.cargo_idcargo =cargo;
        ELSE
            IF doc='' AND nombreApe!='' and cargo!=0 THEN
            	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado,u.recuperacion FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.cargo_idcargo =cargo AND u.nombres like CONCAT('%', nombreApe, '%') or u.apellidos like CONCAT('%', nombreApe, '%');
             ELSE
              IF doc!='' AND nombreApe!='' and cargo!=0 THEN
                          	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado,u.recuperacion FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.cargo_idcargo =cargo AND u.numero_documento LIKE CONCAT(doc, '%') AND (u.nombres like CONCAT('%', nombreApe, '%') or u.apellidos like CONCAT('%', nombreApe, '%'));         ELSE
                  IF doc!='' AND nombreApe='' and cargo!=0 THEN
                                        	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado,u.recuperacion FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.cargo_idcargo =cargo AND u.numero_documento LIKE CONCAT(doc, '%');
                    ELSE
                    IF doc!='' AND nombreApe!='' and cargo=0 THEN
                     SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado,u.recuperacion FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.numero_documento LIKE CONCAT(doc, '%') AND u.nombres like CONCAT('%', nombreApe, '%') or u.apellidos like CONCAT('%', nombreApe, '%');
                    END IF;
                  END IF;
              END IF;
            END IF;
        END IF;
    END IF;
  END IF;
END IF$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_DetalleDelDetalleDelproyecto` (IN `detalle` INT, IN `negocio` INT)  NO SQL
BEGIN

IF negocio=1 THEN
SELECT p.nombre_proceso,Date_Format(f.fecha_inicio,'%d-%M-%Y') as inicio,Date_format(f.fecha_fin,'%d-%M-%Y') as fin,f.cantidad_terminada,f.tiempo_total_por_proceso,f.tiempo_por_unidad,e.nombre as estado,TIME_FORMAT(f.hora_ejecucion,'%r'),TIME_FORMAT(TIMEDIFF(CURRENT_TIME,f.hora_ejecucion),'%H:%i:%s') as tiempoActual,TIME_FORMAT(f.hora_terminacion,'%r') as "hora terminacion",TIME_FORMAT(TIMEDIFF(TIME_FORMAT(f.hora_terminacion,'%H:%i:%s'),TIME_FORMAT(f.hora_ejecucion,'%H:%i:%s')),'%H:%i:%s') as InicioTerminadoIntervalo,f.idDetalle_formato_estandar,f.restantes,f.noperarios FROM detalle_formato_estandar f JOIN procesos p on f.Procesos_idproceso=p.idproceso JOIN estado e on f.estado_idestado=e.idestado where f.detalle_proyecto_idDetalle_proyecto=detalle ORDER BY f.Procesos_idproceso ASC;
ELSE
  IF negocio=2 THEN
  SELECT p.nombre_proceso,Date_Format(f.fecha_inicio,'%d-%M-%Y'),Date_format(f.fecha_fin,'%d-%M-%Y'),f.cantidad_terminada,f.tiempo_total_proceso,f.tiempo_por_unidad,e.nombre,TIME_FORMAT(f.hora_ejecucion,'%r'),TIME_FORMAT(TIMEDIFF(CURRENT_TIME,f.hora_ejecucion),'%H:%i:%s'),TIME_FORMAT(f.hora_terminacion,'%r'),TIME_FORMAT(TIMEDIFF(f.hora_terminacion,f.hora_ejecucion),'%H:%i:%s'),f.idDetalle_teclados,f.restantes,f.noperarios FROM detalle_teclados f JOIN procesos p on f.Procesos_idproceso=p.idproceso JOIN estado e on f.estado_idestado=e.idestado where f.detalle_proyecto_idDetalle_proyecto=detalle ORDER BY f.Procesos_idproceso ASC;
  ELSE
   IF negocio=3 THEN
SELECT p.nombre_proceso,Date_Format(f.fecha_inicio,'%d-%M-%Y'),Date_format(f.fecha_fin,'%d-%M-%Y'),f.cantidad_terminada,f.tiempo_total_por_proceso,f.tiempo_por_unidad,e.nombre,TIME_FORMAT(f.hora_ejecucion,'%r'),TIME_FORMAT(TIMEDIFF(CURRENT_TIME,f.hora_ejecucion),'%H:%i:%s'),TIME_FORMAT(f.hora_terminacion,'%r'),TIME_FORMAT(TIMEDIFF(f.hora_terminacion,f.hora_ejecucion),'%H:%i:%s'),f.idDetalle_ensamble,f.restantes,f.noperarios FROM detalle_ensamble f JOIN procesos p on f.Procesos_idproceso=p.idproceso JOIN estado e on f.estado_idestado=e.idestado where f.detalle_proyecto_idDetalle_proyecto=detalle ORDER BY f.Procesos_idproceso ASC;
   ELSE
    IF negocio=4 THEN
    SELECT p.nombre_proceso,Date_Format(al.fecha_inicio,'%d-%M-%Y'),Date_format(al.fecha_fin,'%d-%M-%Y'),al.cantidad_recibida,al.tiempo_total_proceso,al.tiempo_total_proceso,e.nombre,TIME_FORMAT(al.hora_registro,'%r'),datediff(CURRENT_DATE,al.fecha_inicio) as dias,TIME_FORMAT(al.hora_llegada,'%r'),datediff(al.fecha_fin,al.fecha_inicio),al.idalmacen FROM almacen al JOIN procesos p on al.Procesos_idproceso=p.idproceso JOIN estado e on al.estado_idestado=e.idestado where al.detalle_proyecto_idDetalle_proyecto=detalle ORDER BY al.Procesos_idproceso ASC;
    END IF;
   END IF;
  END IF;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_DetalleDeProduccionProyectosActivos` (IN `orden` INT, IN `negocio` INT, IN `pnc` INT)  NO SQL
BEGIN

SELECT d.idDetalle_proyecto,t.nombre,d.estado_idestado,d.negocio_idnegocio  FROM detalle_proyecto d JOIN tipo_negocio t on d.tipo_negocio_idtipo_negocio=t.idtipo_negocio WHERE d.proyecto_numero_orden=orden and d.negocio_idnegocio=negocio AND d.PNC=pnc AND d.estado_idestado=4;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_DetalleProyectosProduccion` (IN `orden` INT, IN `negocio` INT, IN `pnc` INT)  NO SQL
BEGIN
IF negocio >=1 AND negocio <=4 THEN
#buscar por área de producción
SELECT d.idDetalle_proyecto,t.nombre,d.estado_idestado,d.negocio_idnegocio  FROM detalle_proyecto d JOIN tipo_negocio t on d.tipo_negocio_idtipo_negocio=t.idtipo_negocio WHERE d.proyecto_numero_orden=orden and d.negocio_idnegocio=negocio AND d.PNC=pnc;

ELSE
#Busca todos los detalle del proyecto independientemente el área de produccioó.
SELECT d.idDetalle_proyecto,t.nombre,d.estado_idestado,d.negocio_idnegocio  FROM detalle_proyecto d JOIN tipo_negocio t on d.tipo_negocio_idtipo_negocio=t.idtipo_negocio WHERE d.proyecto_numero_orden=orden AND d.PNC=pnc;

END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_DetallesEnEjecucion` (IN `orden` INT, IN `estado` INT)  NO SQL
BEGIN

IF estado=4 THEN
SELECT dp.idDetalle_proyecto,dp.negocio_idnegocio FROM detalle_proyecto dp WHERE dp.proyecto_numero_orden=orden AND dp.estado_idestado=estado;

ELSE

SELECT dp.idDetalle_proyecto,dp.negocio_idnegocio FROM detalle_proyecto dp WHERE dp.proyecto_numero_orden=orden AND dp.estado_idestado=estado AND dp.negocio_idnegocio=4;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_DetallesparaValidarEstado` (IN `orden` INT)  NO SQL
BEGIN

SELECT dp.idDetalle_proyecto,dp.negocio_idnegocio FROM detalle_proyecto dp WHERE dp.proyecto_numero_orden=orden; 

#AND dp.negocio_idnegocio=negocio;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_DiagramaFETEEN` (IN `op` INT)  NO SQL
BEGIN

IF op=1 THEN

SELECT df.Procesos_idproceso,COUNT(*),df.estado_idestado FROM detalle_formato_estandar df JOIN detalle_proyecto dp ON df.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE df.estado_idestado!=3 AND p.eliminacion=1 GROUP BY df.Procesos_idproceso,df.estado_idestado ORDER BY df.Procesos_idproceso ASC;

ELSE
IF op=2 THEN
SELECT dt.Procesos_idproceso,COUNT(*),dt.estado_idestado FROM detalle_teclados dt JOIN detalle_proyecto dp ON dt.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE dt.estado_idestado!=3 AND p.eliminacion=1 AND dp.estado_idestado!=3 GROUP BY dt.Procesos_idproceso,dt.estado_idestado ORDER BY dt.Procesos_idproceso ASC;

END IF;
SELECT de.Procesos_idproceso,COUNT(*),de.estado_idestado FROM detalle_ensamble de JOIN detalle_proyecto dp ON de.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE de.estado_idestado!=3 AND dp.estado_idestado!=3 AND p.eliminacion=1 GROUP BY de.Procesos_idproceso,de.estado_idestado ORDER BY de.Procesos_idproceso ASC;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_Diagramas` (IN `inicio` VARCHAR(11), IN `fin` VARCHAR(11))  NO SQL
BEGIN

IF inicio='' AND fin='' THEN
#Se consultara todos los proyectos independientemente de la fecha.
SELECT COUNT(*),d.negocio_idnegocio FROM detalle_proyecto d JOIN proyecto p ON d.proyecto_numero_orden=p.numero_orden WHERE p.eliminacion=1 GROUP BY d.negocio_idnegocio;
ELSE
 IF inicio!='' AND fin='' THEN
 #Se consulta solo los que se ingresaron ese día.
 SELECT COUNT(*),d.negocio_idnegocio FROM detalle_proyecto d JOIN proyecto p ON d.proyecto_numero_orden=p.numero_orden WHERE p.eliminacion=1 AND DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y')= DATE_FORMAT(inicio,'%d-%M-%Y') GROUP BY d.negocio_idnegocio;
 ELSE
  IF inicio!='' AND fin!='' THEN
  SELECT COUNT(*),d.negocio_idnegocio FROM detalle_proyecto d JOIN proyecto p ON d.proyecto_numero_orden=p.numero_orden WHERE p.eliminacion=1 AND DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y') BETWEEN DATE_FORMAT(inicio,'%d-%M-%Y') AND DATE_FORMAT(fin,'%d-%M-%Y')  GROUP BY d.negocio_idnegocio; 
  END IF;
 END IF;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_EjecucionoParada` (IN `orden` INT, IN `op` INT)  NO SQL
BEGIN

UPDATE proyecto p SET p.parada=op WHERE p.numero_orden=orden;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_EliminarCambiarEstadoProyecto` (IN `orden` INT)  NO SQL
BEGIN
#Estado 1 es activado y estado 0 es desactivado
#No se pueden eliminar los proyectos de la base de datos.
UPDATE proyecto p SET p.eliminacion=0 WHERE p.numero_orden=orden;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_EliminarProductosNoConformes` (IN `orden` INT, IN `tipo` INT, IN `negocio` INT)  NO SQL
BEGIN

SELECT d.idDetalle_proyecto FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.tipo_negocio_idtipo_negocio=tipo AND d.negocio_idnegocio=negocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_FechaServidor` ()  NO SQL
SELECT DATE_FORMAT(CURDATE(),'%d-%M-%Y')$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformacionDeTodaElAreaDeProduccion` ()  NO SQL
BEGIN
DECLARE cantidadP int;
SET cantidadP=(SELECT COUNT(numero_orden) FROM proyecto p WHERE p.eliminacion=1);

SELECT  DATE_FORMAT(CURDATE(),'%d-%M-%Y') as fecha,COUNT(*) as cantidad,cantidadP,d.negocio_idnegocio FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden WHERE d.PNC=0 AND p.eliminacion=1 GROUP BY d.negocio_idnegocio ORDER BY d.negocio_idnegocio ASC;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformacionFiltrariaDetalleProyecto` (IN `iddetalle` INT)  NO SQL
BEGIN

SELECT p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y') as fechaIngreso,DATE_FORMAT(p.fecha_entrega,'%d-%M-%Y')AS fechaEntrega,dp.canitadad_total,dp.tiempo_total,DATE_FORMAT(p.entregaCircuitoFEoGF,'%d-%M-%Y') AS fecha1,DATE_FORMAT(p.entregaCOMCircuito,'%d-%M-%Y') AS fecha2,DATE_FORMAT(p.entregaPCBFEoGF,'%d-%M-%Y') AS fecha3,DATE_FORMAT(p.entregaPCBCom,'%d-%M-%Y') AS fecha4 FROM proyecto p JOIN detalle_proyecto dp ON p.numero_orden=dp.proyecto_numero_orden WHERE dp.idDetalle_proyecto=iddetalle;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformacionProyectosProduccion` (IN `negocio` INT, IN `orden` INT, IN `clien` VARCHAR(40), IN `proyecto` VARCHAR(40), IN `tipo` VARCHAR(6))  NO SQL
BEGIN

IF orden=0 AND clien='' AND proyecto='' AND tipo='' THEN
  SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT join proyecto p ON p.numero_orden=d.proyecto_numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) and p.eliminacion=1;
ELSE
 IF orden!=0 AND clien='' AND proyecto='' AND tipo='' THEN
 	 SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT join proyecto p ON p.numero_orden=d.proyecto_numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%') and p.eliminacion=1;
 ELSE
  IF orden=0 AND clien!='' AND proyecto='' AND tipo='' THEN
SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where  ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) and p.nombre_cliente LIKE CONCAT('%',clien,'%') and p.eliminacion=1;
  ELSE
   IF orden=0 AND clien='' AND proyecto!='' AND tipo='' THEN
   	  SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') and p.eliminacion=1;
   ELSE
    IF orden=0 AND clien='' AND proyecto='' AND tipo!='' THEN
       SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND p.tipo_proyecto=tipo and p.eliminacion=1;
    ELSE
     IF orden!=0 AND clien!='' AND proyecto='' AND tipo='' THEN
        SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%') AND p.nombre_cliente LIKE CONCAT('%',clien,'%') AND p.eliminacion=1;
     ELSE 
      IF orden!=0 AND clien='' AND proyecto!='' AND tipo='' THEN
        SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%') AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') and p.eliminacion=1;
      ELSE
       IF orden!=0 AND clien='' AND proyecto='' AND tipo!='' THEN
       	 SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%') AND p.tipo_proyecto=tipo and p.eliminacion=1;
       ELSE
        IF orden=0 AND clien!='' AND proyecto!='' AND tipo='' THEN
          SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND p.nombre_cliente LIKE      CONCAT('%',clien,'%') AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') and p.eliminacion=1;
        ELSE
         IF orden=0 AND clien!='' AND proyecto='' AND tipo!='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND p.nombre_cliente LIKE      CONCAT('%',clien,'%') AND p.tipo_proyecto=tipo and p.eliminacion=1;
         ELSE
          IF orden=0 AND clien='' AND proyecto!='' AND tipo!='' THEN
            SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND p.nombre_proyecto LIKE    CONCAT(proyecto,'%') AND p.tipo_proyecto=tipo AND p.eliminacion=1;
          ELSE
           IF orden!=0 AND clien!='' AND proyecto!='' AND tipo='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%') AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') AND p.nombre_cliente LIKE CONCAT('%',clien,'%') AND p.eliminacion=1;
           ELSE
            IF orden=0 AND clien!='' AND proyecto!='' AND tipo!='' THEN
             SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND p.tipo_proyecto=tipo AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') AND p.nombre_cliente LIKE CONCAT('%',clien,'%') and p.eliminacion=1;
            ELSE
             IF orden!=0 AND clien='' AND proyecto!='' AND tipo!='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%') AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') AND p.tipo_proyecto=tipo AND p.eliminacion=1;
             ELSE
              IF orden!=0 AND clien!='' AND proyecto='' AND tipo!='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on 
d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%') AND p.nombre_cliente LIKE 
CONCAT('%',clien,'%') AND p.tipo_proyecto=tipo AND p.eliminacion=1;
              ELSE
               IF orden!=0 AND clien!='' AND proyecto!='' AND tipo!='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto,p.parada FROM detalle_proyecto d RIGHT JOIN proyecto p on 
d.proyecto_numero_orden=p.numero_orden where ((p.fecha_salidal is null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio AND (d.estado_idestado=1 or d.estado_idestado=2 OR d.estado_idestado=4)) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%') AND p.nombre_cliente LIKE 
CONCAT('%',clien,'%') AND p.nombre_cliente LIKE CONCAT(proyecto,'%') AND p.tipo_proyecto=tipo AND                             p.eliminacion=1;
               END IF;
              END IF;
             END IF;
            END IF; 
           END IF;
          END IF; 
         END IF; 
        END IF;
       END IF;
      END IF;
     END IF;
    END IF;
   END IF;
  END IF;
 END IF;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformacionQR` (IN `orden` INT)  NO SQL
BEGIN
SELECT d.idDetalle_proyecto,d.tipo_negocio_idtipo_negocio,d.negocio_idnegocio from detalle_proyecto d JOIN tipo_negocio t ON d.tipo_negocio_idtipo_negocio=t.idtipo_negocio where d.proyecto_numero_orden=orden and d.PNC=0;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformeDeProduccionEN` (IN `orden` INT)  NO SQL
BEGIN

IF orden=0 THEN
#consulta todos
SELECT dp.proyecto_numero_orden,n.nom_negocio,tn.nombre,MAX(de.Procesos_idproceso) AS proceso,DATEDIFF(p.fecha_entrega,CURRENT_DATE) AS dias,dp.estado_idestado FROM proyecto p JOIN detalle_proyecto dp ON p.numero_orden=dp.proyecto_numero_orden JOIN detalle_ensamble de ON dp.idDetalle_proyecto=de.detalle_proyecto_idDetalle_proyecto JOIN negocio n ON dp.negocio_idnegocio=n.idnegocio JOIN tipo_negocio tn ON dp.tipo_negocio_idtipo_negocio=tn.idtipo_negocio WHERE dp.PNC=0 AND p.estado_idestado!=3 AND p.eliminacion=1 AND de.estado_idestado!=1 GROUP BY dp.proyecto_numero_orden, dp.tipo_negocio_idtipo_negocio;

ELSE
#Consulta por la orden
SELECT dp.proyecto_numero_orden,n.nom_negocio,tn.nombre,MAX(de.Procesos_idproceso) AS proceso,DATEDIFF(p.fecha_entrega,CURRENT_DATE) AS dias,dp.estado_idestado FROM proyecto p JOIN detalle_proyecto dp ON p.numero_orden=dp.proyecto_numero_orden JOIN detalle_ensamble de ON dp.idDetalle_proyecto=de.detalle_proyecto_idDetalle_proyecto JOIN negocio n ON dp.negocio_idnegocio=n.idnegocio JOIN tipo_negocio tn ON dp.tipo_negocio_idtipo_negocio=tn.idtipo_negocio WHERE dp.proyecto_numero_orden LIKE CONCAT(orden,'%') AND dp.PNC=0 AND p.estado_idestado!=3 AND p.eliminacion=1 AND de.estado_idestado!=1 GROUP BY dp.proyecto_numero_orden, dp.tipo_negocio_idtipo_negocio;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformeDeProduccionFE` (IN `orden` INT)  NO SQL
BEGIN


IF orden= 0 THEN
#Consulta todos
SELECT dp.proyecto_numero_orden,n.nom_negocio,tn.nombre,MAX(df.Procesos_idproceso) AS proceso,DATEDIFF(p.fecha_entrega,CURRENT_DATE) AS dias,dp.estado_idestado FROM proyecto p JOIN detalle_proyecto dp ON p.numero_orden=dp.proyecto_numero_orden JOIN detalle_formato_estandar df ON dp.idDetalle_proyecto=df.detalle_proyecto_idDetalle_proyecto JOIN negocio n ON dp.negocio_idnegocio=n.idnegocio JOIN tipo_negocio tn ON dp.tipo_negocio_idtipo_negocio=tn.idtipo_negocio WHERE dp.PNC=0 AND p.estado_idestado!=3 AND p.eliminacion=1 AND df.estado_idestado!=1 GROUP BY dp.proyecto_numero_orden, dp.tipo_negocio_idtipo_negocio;

ELSE
#Consulta por la orden
SELECT dp.proyecto_numero_orden,n.nom_negocio,tn.nombre,MAX(df.Procesos_idproceso) AS proceso,DATEDIFF(p.fecha_entrega,CURRENT_DATE) AS dias,dp.estado_idestado FROM proyecto p JOIN detalle_proyecto dp ON p.numero_orden=dp.proyecto_numero_orden JOIN detalle_formato_estandar df ON dp.idDetalle_proyecto=df.detalle_proyecto_idDetalle_proyecto JOIN negocio n ON dp.negocio_idnegocio=n.idnegocio JOIN tipo_negocio tn ON dp.tipo_negocio_idtipo_negocio=tn.idtipo_negocio WHERE dp.proyecto_numero_orden LIKE CONCAT(orden,'%') AND dp.PNC=0 AND p.estado_idestado!=3 AND p.eliminacion=1 AND df.estado_idestado!=1 GROUP BY dp.proyecto_numero_orden, dp.tipo_negocio_idtipo_negocio;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformeDeProduccionTE` (IN `orden` INT)  NO SQL
BEGIN

IF orden=0 THEN
#Consulta todos
SELECT dp.proyecto_numero_orden,n.nom_negocio,tn.nombre,MAX(dt.Procesos_idproceso) AS proceso,DATEDIFF(p.fecha_entrega,CURRENT_DATE) AS dias,dp.estado_idestado FROM proyecto p JOIN detalle_proyecto dp ON p.numero_orden=dp.proyecto_numero_orden JOIN detalle_teclados dt ON dp.idDetalle_proyecto=dt.detalle_proyecto_idDetalle_proyecto JOIN negocio n ON dp.negocio_idnegocio=n.idnegocio JOIN tipo_negocio tn ON dp.tipo_negocio_idtipo_negocio=tn.idtipo_negocio WHERE dp.PNC=0 AND p.estado_idestado!=3 AND p.eliminacion=1 AND dt.estado_idestado!=1 GROUP BY dp.proyecto_numero_orden, dp.tipo_negocio_idtipo_negocio;

ELSE
#Consulta por la orden de proyecto
SELECT dp.proyecto_numero_orden,n.nom_negocio,tn.nombre,MAX(dt.Procesos_idproceso) AS proceso,DATEDIFF(p.fecha_entrega,CURRENT_DATE) AS dias,dp.estado_idestado FROM proyecto p JOIN detalle_proyecto dp ON p.numero_orden=dp.proyecto_numero_orden JOIN detalle_teclados dt ON dp.idDetalle_proyecto=dt.detalle_proyecto_idDetalle_proyecto JOIN negocio n ON dp.negocio_idnegocio=n.idnegocio JOIN tipo_negocio tn ON dp.tipo_negocio_idtipo_negocio=tn.idtipo_negocio WHERE dp.proyecto_numero_orden LIKE CONCAT(orden,'%') AND dp.PNC=0 AND p.estado_idestado!=3 AND p.eliminacion=1 AND dt.estado_idestado!=1 GROUP BY dp.proyecto_numero_orden, dp.tipo_negocio_idtipo_negocio;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_IniciarRenaudarTomaDeTiempoProcesos` (IN `orden` INT, IN `detalle` INT, IN `lector` INT, IN `busqueda` INT, IN `oper` INT(3))  NO SQL
BEGIN
DECLARE id int;
DECLARE id1 int;
DECLARE cantidadp int;

IF busqueda=1 THEN

set id=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=1);

set id1=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=2);

IF id !='null' THEN
UPDATE detalle_formato_estandar f SET f.fecha_inicio=CURDATE(), f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.noperarios=oper WHERE f.idDetalle_formato_estandar=id;
END IF;

IF id1 !='null' THEN
UPDATE detalle_formato_estandar f SET  f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.hora_terminacion=null,f.noperarios=oper WHERE f.idDetalle_formato_estandar=id1;
END IF;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalle;

ELSE
  IF busqueda=2 THEN
  
  set id=(SELECT f.idDetalle_teclados from detalle_teclados f LEFT JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=1);

set id1=(SELECT f.idDetalle_teclados from detalle_teclados f LEFT JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=2);

IF id !='null' THEN
UPDATE detalle_teclados f SET f.fecha_inicio=CURDATE(), f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.noperarios=oper WHERE f.idDetalle_teclados=id ;
END IF;

IF id1 !='null' THEN
UPDATE detalle_teclados f SET f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.hora_terminacion=null,f.noperarios=oper WHERE f.idDetalle_teclados=id1 ;
END IF;
  
  SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalle;
  
  ELSE 
    IF busqueda =3 THEN
    
set id=(SELECT f.idDetalle_ensamble from detalle_ensamble f LEFT JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=1);

set id1=(SELECT f.idDetalle_ensamble from detalle_ensamble f LEFT JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=2); 

IF id !='null' THEN
UPDATE detalle_ensamble f SET f.fecha_inicio=CURDATE(), f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.noperarios=oper WHERE f.idDetalle_ensamble=id;
END IF;

IF id1 !='null' THEN
UPDATE detalle_ensamble f SET  f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.hora_terminacion=null,f.noperarios=oper WHERE f.idDetalle_ensamble=id1 ;
END IF;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalle;
 
    
    END IF;  
  END IF;
END IF;
      #Se encarga de cambier el estado de los detalles del proyecto
      CALL PA_CambiarEstadoDeProductos(busqueda,detalle);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_IniciarTomaTiempoDetalleAlmacen` (IN `detalle` INT)  NO SQL
BEGIN

UPDATE almacen a SET a.estado_idestado=4 WHERE a.detalle_proyecto_idDetalle_proyecto=detalle;

 UPDATE detalle_proyecto dp SET pro_Pausado=0,pro_Ejecucion=1 WHERE idDetalle_proyecto=detalle; 

CALL PA_CambiarEstadoDeProductos(4,detalle);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ModificarDetalleFormatoEstandar` (IN `orden` INT, IN `detalle` INT, IN `material` VARCHAR(2))  NO SQL
BEGIN
#DECLARE cantidadp int;

IF EXISTS(SELECT * FROM detalle_formato_estandar d  WHERE d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=2) THEN   
  IF material = 'FV' then
     #si no el materia no es "TH" se eliminara este proceso
   DELETE FROM detalle_formato_estandar  WHERE detalle_proyecto_idDetalle_proyecto=detalle and Procesos_idproceso=2; 
    #SELECT 'Ya existe TH';
     #Fin de la eliminacion
     END IF;
ELSE
    IF material='TH' then
    #SELECT 'No existe el TH';
     #si el materia es "TH" se registrara este proceso
     INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,2,1);
   END IF;
END IF;

  

IF (SELECT tipo_negocio_idtipo_negocio from detalle_proyecto WHERE proyecto_numero_orden=orden and idDetalle_proyecto=detalle
)=1  THEN


  IF (SELECT ruteoC from proyecto WHERE numero_orden=orden)=1 THEN
    
     IF (SELECT f.Procesos_idproceso from detalle_proyecto d JOIN detalle_formato_estandar f ON 
     d.idDetalle_proyecto=f.detalle_proyecto_idDetalle_proyecto WHERE d.proyecto_numero_orden=orden and 
     f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=9) THEN         
	   select "hola1";    
      ELSE
     INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, 
     `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
     ('00:00','00:00','0',detalle,9,1);
    END IF;
       
    ELSE
       
      IF (SELECT f.Procesos_idproceso from detalle_proyecto d JOIN detalle_formato_estandar f ON 
      d.idDetalle_proyecto=f.detalle_proyecto_idDetalle_proyecto WHERE d.proyecto_numero_orden=orden and 
      f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=9) THEN
        DELETE FROM detalle_formato_estandar  WHERE detalle_proyecto_idDetalle_proyecto=detalle and Procesos_idproceso=9; 
      END IF;
    
  END IF;
  
 IF (SELECT antisolderC from proyecto WHERE numero_orden=orden)=1 THEN
    
     IF (SELECT f.Procesos_idproceso from detalle_proyecto d JOIN detalle_formato_estandar f ON 
     d.idDetalle_proyecto=f.detalle_proyecto_idDetalle_proyecto WHERE d.proyecto_numero_orden=orden and 
     f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=6) THEN         
	   select "hola1";    
      ELSE
     INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, 
     `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
     ('00:00','00:00','0',detalle,6,1);
    END IF;
       
    ELSE
       
      IF (SELECT f.Procesos_idproceso from detalle_proyecto d JOIN detalle_formato_estandar f ON 
      d.idDetalle_proyecto=f.detalle_proyecto_idDetalle_proyecto WHERE d.proyecto_numero_orden=orden and 
      f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=6) THEN
        DELETE FROM detalle_formato_estandar  WHERE detalle_proyecto_idDetalle_proyecto=detalle and Procesos_idproceso=6; 
      END IF;
    
  END IF;


    ELSE
    

  IF (SELECT ruteoP from proyecto WHERE numero_orden=orden)=1 THEN
    
     IF (SELECT f.Procesos_idproceso from detalle_proyecto d JOIN detalle_formato_estandar f ON 
     d.idDetalle_proyecto=f.detalle_proyecto_idDetalle_proyecto WHERE d.proyecto_numero_orden=orden and 
     f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=9) THEN         
	   select "hola1";    
      ELSE
     INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, 
     `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
     ('00:00','00:00','0',detalle,9,1);
    END IF;
       
    ELSE
       
      IF (SELECT f.Procesos_idproceso from detalle_proyecto d JOIN detalle_formato_estandar f ON 
      d.idDetalle_proyecto=f.detalle_proyecto_idDetalle_proyecto WHERE d.proyecto_numero_orden=orden and 
      f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=9) THEN
        DELETE FROM detalle_formato_estandar  WHERE detalle_proyecto_idDetalle_proyecto=detalle and Procesos_idproceso=9; 
      END IF;
    
  END IF;

 IF (SELECT antisolderP from proyecto WHERE numero_orden=orden)=1 THEN
    
     IF (SELECT f.Procesos_idproceso from detalle_proyecto d JOIN detalle_formato_estandar f ON 
     d.idDetalle_proyecto=f.detalle_proyecto_idDetalle_proyecto WHERE d.proyecto_numero_orden=orden and 
     f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=6) THEN         
	   select "hola1";    
      ELSE
     INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, 
     `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
     ('00:00','00:00','0',detalle,6,1);
    END IF;
       
    ELSE
       
      IF (SELECT f.Procesos_idproceso from detalle_proyecto d JOIN detalle_formato_estandar f ON 
      d.idDetalle_proyecto=f.detalle_proyecto_idDetalle_proyecto WHERE d.proyecto_numero_orden=orden and 
      f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=6) THEN
        DELETE FROM detalle_formato_estandar  WHERE detalle_proyecto_idDetalle_proyecto=detalle and Procesos_idproceso=6; 
      END IF;
    
  END IF;

END IF;

#SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(SELECT MAX(idDetalle_proyecto) FROM detalle_proyecto) AND d.estado_idestado=1);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_NumeroOperarios` (IN `detalle` INT, IN `lector` INT, IN `negocio` INT)  NO SQL
BEGIN

IF negocio=1 THEN
#Formato estandar
SELECT f.noperarios FROM detalle_formato_estandar f WHERE f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=lector;
ELSE
 IF negocio=2 THEN
 #Teclados
 SELECT f.noperarios FROM detalle_teclados f WHERE f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=lector;
 ELSE
 #Ensamble
 SELECT f.noperarios FROM detalle_ensamble f WHERE f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=lector;
 END IF;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_PararTomaDeTiempoAlmacen` (IN `detalle` INT, IN `proceso` INT, IN `cantidad` INT, IN `estado` INT)  NO SQL
BEGIN
DECLARE fecha varchar(11);
IF estado=3 THEN
#Cuando el estado es terminado
#Dias totales del proceso
SET fecha=(SELECT datediff(CURRENT_DATE,al.fecha_inicio) FROM almacen al WHERE al.detalle_proyecto_idDetalle_proyecto=detalle AND al.Procesos_idproceso=proceso);

UPDATE almacen a SET a.fecha_fin=CURRENT_DATE, a.hora_llegada=CURRENT_TIME,a.cantidad_recibida=cantidad,a.estado_idestado=3,a.tiempo_total_proceso=datediff(CURRENT_DATE,a.fecha_inicio) WHERE a.detalle_proyecto_idDetalle_proyecto=detalle AND a.Procesos_idproceso=proceso;

UPDATE detalle_proyecto SET pro_Terminado=1 WHERE idDetalle_proyecto=detalle;

UPDATE detalle_proyecto  SET pro_Ejecucion=0 WHERE idDetalle_proyecto=detalle;

UPDATE detalle_proyecto dp SET dp.tiempo_total=fecha WHERE dp.idDetalle_proyecto=detalle; 

ELSE
 IF estado=2 THEN
 #Cuando el proyecto cambia a estado de pausa
 UPDATE almacen a SET a.estado_idestado=2 WHERE a.detalle_proyecto_idDetalle_proyecto=detalle;
 UPDATE detalle_proyecto dp SET pro_Pausado=1,pro_Ejecucion=0 WHERE idDetalle_proyecto=detalle; 
 
 else
#Cuando no se termina el proceso
UPDATE almacen a SET a.cantidad_recibida=cantidad,a.estado_idestado=4 WHERE a.detalle_proyecto_idDetalle_proyecto=detalle AND a.Procesos_idproceso=proceso;

UPDATE detalle_proyecto  SET pro_Ejecucion=1 WHERE idDetalle_proyecto=detalle; 
 
 END IF;
END IF;

CALL PA_CambiarEstadoDeProductos(4,detalle);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_PausarTomaDeTiempoDeProcesos` (IN `orden` INT, IN `detalle` INT, IN `lector` INT, IN `busqueda` INT, IN `tiempo` VARCHAR(8), IN `cantidad` INT, IN `est` TINYINT(1), IN `res` INT)  NO SQL
BEGIN
DECLARE id int;
DECLARE cantidadp int;
IF est=2 THEN

IF busqueda=1 THEN

SET id=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 UPDATE detalle_formato_estandar f SET  f.estado_idestado=est, f.tiempo_total_por_proceso=tiempo,f.cantidad_terminada=cantidad,f.restantes=res,f.noperarios=0 WHERE f.idDetalle_formato_estandar=id ;

ELSE
 IF busqueda=2 THEN
 
 SET id=(SELECT f.idDetalle_teclados from detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 UPDATE detalle_teclados f SET  f.estado_idestado=est, f.tiempo_total_proceso=tiempo, f.cantidad_terminada=cantidad,f.restantes=res,f.noperarios=0 WHERE f.idDetalle_teclados=id ;
 
 ELSE
  IF busqueda=3 THEN
  
  SET id=(SELECT f.idDetalle_ensamble from detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
  
  UPDATE detalle_ensamble f SET  f.estado_idestado=est, f.tiempo_total_por_proceso=tiempo,f.cantidad_terminada=cantidad,f.restantes=res,f.noperarios=0 WHERE f.idDetalle_ensamble=id ;
  
  END IF; 
 END IF;
END IF;

ELSE

IF busqueda=1 THEN

SET id=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 UPDATE detalle_formato_estandar f SET  f.estado_idestado=est,f.fecha_fin=CURRENT_DATE,f.tiempo_total_por_proceso=tiempo,f.cantidad_terminada=cantidad,f.restantes=res,f.noperarios=0 WHERE f.idDetalle_formato_estandar=id ;

ELSE
 IF busqueda=2 THEN
 
 SET id=(SELECT f.idDetalle_teclados from detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 UPDATE detalle_teclados f SET  f.estado_idestado=est,f.fecha_fin=CURRENT_DATE, f.tiempo_total_proceso=tiempo, f.cantidad_terminada=cantidad,f.restantes=res,f.noperarios=0 WHERE f.idDetalle_teclados=id ;
 
 ELSE
  IF busqueda=3 THEN
  
  SET id=(SELECT f.idDetalle_ensamble from detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
  
  UPDATE detalle_ensamble f SET  f.estado_idestado=est,f.fecha_fin=CURRENT_DATE, f.tiempo_total_por_proceso=tiempo,f.cantidad_terminada=cantidad,f.restantes=res,f.noperarios=0 WHERE f.idDetalle_ensamble=id;
  
  END IF; 
 END IF;
END IF;

END IF;

IF busqueda=1 THEN

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalle;

ELSE
 IF busqueda=2 THEN
 
 SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalle;
 
 ELSE
  if busqueda=3 THEN
  
  SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalle;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalle) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalle;
  
  END IF;
 END IF;
END IF;
     CALL PA_CambiarEstadoDeProductos(busqueda,detalle);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_PromedioProductoPorMinuto` (IN `detalle` INT, IN `negocio` INT, IN `lector` INT)  NO SQL
BEGIN
#Formato estándar
IF negocio=1 THEN

SELECT d.tiempo_total_por_proceso,d.cantidad_terminada FROM detalle_formato_estandar d WHERE d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=lector AND d.estado_idestado=3;

ELSE
#Teclados
 IF negocio=2 THEN

SELECT d.tiempo_total_proceso,d.cantidad_terminada FROM detalle_teclados d WHERE d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=lector AND d.estado_idestado=3;

 ELSE
 #Ensamble
 
 SELECT d.tiempo_total_por_proceso,d.cantidad_terminada FROM detalle_ensamble d WHERE d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=lector AND d.estado_idestado=3;
 
 END IF;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ProyectosEnEjecucion` (IN `negocio` INT)  NO SQL
BEGIN

IF negocio=1 THEN

SELECT d.proyecto_numero_orden FROM detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto WHERE f.estado_idestado=4 GROUP BY d.proyecto_numero_orden;


else
 IF negocio=2 THEN

SELECT d.proyecto_numero_orden FROM detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto WHERE f.estado_idestado=4 GROUP BY d.proyecto_numero_orden;

 ELSE
  IF negocio=3 THEN

SELECT d.proyecto_numero_orden FROM detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto WHERE f.estado_idestado=4 GROUP BY d.proyecto_numero_orden;

  END IF;
 END IF;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ReactivarProyecto` (IN `orden` INT)  NO SQL
BEGIN

UPDATE proyecto p SET p.eliminacion=1 WHERE p.numero_orden=orden;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RecuperaContraseñaUser` (IN `rec` VARCHAR(10))  NO SQL
BEGIN

IF EXISTS(SELECT u.numero_documento FROM usuario u WHERE u.recuperacion=rec) THEN

SELECT u.numero_documento,u.contraeña FROM usuario u WHERE u.recuperacion=rec;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleAlmacen` (IN `orden` INT, IN `tipo` INT, IN `proceso` INT)  NO SQL
BEGIN
#variables
DECLARE detalle int;
DECLARE cantidad int;

set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=4));

#Proceso de inserción
INSERT INTO `almacen`(`tiempo_total_proceso`, `cantidad_recibida`, `fecha_inicio`,`detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`, `hora_registro`) VALUES ('0','0',now(),detalle,proceso,4,CURRENT_TIME);

SET cantidad= (SELECT COUNT(*) FROM almacen a WHERE  a.detalle_proyecto_idDetalle_proyecto=detalle AND a.estado_idestado=4);


UPDATE detalle_proyecto d SET d.pro_Ejecucion=cantidad WHERE idDetalle_proyecto=detalle;

CALL PA_CambiarEstadoDeProductos(4,detalle);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleEnsamble` (IN `orden` INT, IN `tipo` INT, IN `ubic` VARCHAR(25))  NO SQL
BEGIN

DECLARE detalle int;

IF ubic='' THEN
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=3 AND dd.ubicacion is null));

ELSE
 
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=3 AND dd.ubicacion=ubic));

END IF;
#Manual
INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,15,1);

#Limpieza
INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,16,1);

#Control calidad
INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,17,1);


#Empaque
INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,18,1);

#Stencil
INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,19,1);

#Linea
INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,20,1);

#Arnes
INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,21,1);


UPDATE detalle_proyecto SET pro_porIniciar=7 WHERE idDetalle_proyecto=detalle;

#Actualización de estado
CALL PA_CambiarEstadoDeProductos(3,detalle);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleFormatoEstandar` (IN `orden` INT, IN `tipo` INT, IN `ubic` VARCHAR(25))  NO SQL
BEGIN
DECLARE material varchar(3);
DECLARE antisolder int;
declare ruteo int;
declare detalle int;

 IF ubic='' THEN
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=1 AND dd.ubicacion is null));

 ELSE
 
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=1 AND dd.ubicacion=ubic));

 END IF;



IF tipo=2 THEN
INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,1,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,3,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,4,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,5,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,7,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,8,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,9,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,10,1);
ELSE
IF tipo=3 or tipo=4 THEN
 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,1,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,4,1);
ELSE
   IF tipo=6 THEN
 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,1,1);
ELSE
     IF tipo=1 or tipo=7 THEN
 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,1,1);


set material=(SELECT d.material from detalle_proyecto d WHERE d.proyecto_numero_orden=(orden) AND d.idDetalle_proyecto=detalle);


IF material="TH" THEN
 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,2,1);
#ELSE
#DELETE FROM detalle_formato_estandar  WHERE detalle_proyecto_idDetalle_proyecto=detalle AND Procesos_idproceso=2; 
END IF;


 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,3,1);

 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,4,1);

INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,5,1);

     IF tipo=1 THEN
set antisolder=(SELECT antisolderC from proyecto where numero_orden=(SELECT proyecto_numero_orden from detalle_proyecto WHERE idDetalle_proyecto=detalle));

set ruteo=(SELECT ruteoC from proyecto where numero_orden=(SELECT proyecto_numero_orden from detalle_proyecto WHERE idDetalle_proyecto=detalle));

 IF antisolder=1 THEN
 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,6,1);
 END IF;
 
INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,7,1);

 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,8,1);

  IF ruteo=1 THEN
 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,9,1);
 END IF;
     END IF;
          IF tipo=7 THEN
          
set antisolder=(SELECT antisolderP from proyecto where numero_orden=(SELECT proyecto_numero_orden from detalle_proyecto WHERE idDetalle_proyecto=detalle));

set ruteo=(SELECT ruteoP from proyecto where numero_orden=(SELECT proyecto_numero_orden from detalle_proyecto WHERE idDetalle_proyecto=detalle));
 IF antisolder=1 THEN
 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,6,1);
 END IF;
INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,7,1);

 INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,8,1);

  IF ruteo=1 THEN
INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,9,1);
 END IF;
          END IF;
INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('00:00','00:00','0',detalle,10,1);
   END IF;
  END IF;
 END IF;
END IF;

SET tipo= (SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=detalle AND d.estado_idestado=1);


UPDATE detalle_proyecto SET pro_porIniciar=tipo WHERE idDetalle_proyecto=detalle;

#Cambio de estados
CALL PA_CambiarEstadoDeProductos(1,detalle);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleProyectoQR` (IN `orden` INT, IN `area` INT, IN `producto` INT, IN `cantidad` VARCHAR(25), IN `material` VARCHAR(25), IN `ruteo` INT, IN `antisolder` INT)  NO SQL
BEGIN

#Actualizamos primero los detalles del proyecto
IF producto=1 AND area=1 THEN
UPDATE proyecto p SET p.FE=1,p.pcb_FE=1,p.antisolderC=antisolder,p.ruteoC=ruteo WHERE p.numero_orden=orden;
ELSE
 IF producto=1 AND area=3 THEN
 #Integracion
 UPDATE proyecto p SET p.IN=1 WHERE p.numero_orden=orden;
 ELSE
  IF producto=5 THEN
  #Teclado 
  UPDATE proyecto p SET p.TE=1 WHERE p.numero_orden=orden;
  ELSE
   IF producto=2 THEN
   	#Formato estandar Conversor
   UPDATE proyecto p SET p.TE=1,p.FE=1,p.Conversor=1 WHERE p.numero_orden=orden;
   ELSE 
    IF producto=3 THEN
     #Formato estandar Repujado
    UPDATE proyecto p SET p.TE=1,p.FE=1,p.Repujado=1 WHERE p.numero_orden=orden;
    ELSE
     IF producto=4 THEN
      #Formato estandar Troquel
     UPDATE proyecto p SET p.TE=1,p.FE=1,p.troquel=1 WHERE p.numero_orden=orden;
     ELSE
      IF producto=6 THEN
       #Formato estandar Stencil
       UPDATE proyecto p SET p.FE=1,p.IN=1,p.stencil=1 WHERE p.numero_orden=orden;
       ELSE
        IF producto=7 THEN
        #Formato estandar PCB
         UPDATE proyecto p SET p.FE=1,p.TE=1,p.pcb_TE=1,p.antisolderP=antisolder,p.ruteoP=ruteo WHERE p.numero_orden=orden;
        END IF;
      END IF;
     END IF;
    END IF;
   END IF;
  END IF;
 END IF;
END IF;
#Inserción de datos
IF material != '' THEN
INSERT INTO `detalle_proyecto`(`tipo_negocio_idtipo_negocio`, `canitadad_total`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`,`material`,`PNC`) VALUES (producto,cantidad,orden,area,1,material,0);
SELECT 1;
ELSE
INSERT INTO `detalle_proyecto`(`tipo_negocio_idtipo_negocio`, `canitadad_total`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`,`PNC`) VALUES (producto,cantidad,orden,area,1,0);
SELECT 1;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleTeclados` (IN `orden` INT, IN `tipo` INT, IN `ubic` VARCHAR(25))  NO SQL
BEGIN

DECLARE detalle int;

IF ubic='' THEN
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=2 AND dd.ubicacion is null));

ELSE
 
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=2 AND dd.ubicacion=ubic));

END IF;

INSERT INTO `detalle_teclados`(`tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`)VALUES
('00:00','00:00','0',detalle,11,1);

INSERT INTO `detalle_teclados`(`tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`)VALUES
('00:00','00:00','0',detalle,12,1);

INSERT INTO `detalle_teclados`(`tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`)VALUES
('00:00','00:00','0',detalle,13,1);

INSERT INTO `detalle_teclados`(`tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`)VALUES
('00:00','00:00','0',detalle,14,1);

UPDATE detalle_proyecto SET pro_porIniciar=4 WHERE idDetalle_proyecto=detalle;

#Cambio de estado del proyecto
CALL PA_CambiarEstadoDeProductos(2,detalle);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ReporteGeneral` ()  NO SQL
BEGIN

SELECT p.numero_orden,p.nombre_cliente,p.nombre_proyecto,dp.canitadad_total,n.nom_negocio,t.nombre,dp.Total_timepo_Unidad,dp.tiempo_total FROM detalle_proyecto dp JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden JOIN negocio n on dp.negocio_idnegocio=n.idnegocio JOIN tipo_negocio t ON dp.tipo_negocio_idtipo_negocio=t.idtipo_negocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_Sesion` (IN `sec` INT, IN `ced` VARCHAR(13))  NO SQL
BEGIN

UPDATE usuario u SET u.sesion=sec WHERE u.numero_documento=ced;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_TiempoProceso` (IN `detalle` INT, IN `negocio` INT)  NO SQL
BEGIN

IF negocio=1 THEN
#Formato estandar
SELECT df.tiempo_total_por_proceso FROM detalle_formato_estandar df WHERE df.detalle_proyecto_idDetalle_proyecto=detalle AND df.estado_idestado!=1;

ELSE
 IF negocio=2 THEN
 #Teclados
 SELECT dt.tiempo_total_proceso FROM detalle_teclados dt WHERE dt.detalle_proyecto_idDetalle_proyecto=detalle AND dt.estado_idestado!=1;
 ELSE
 #Ensamble
 SELECT de.tiempo_total_por_proceso FROM detalle_ensamble de WHERE de.detalle_proyecto_idDetalle_proyecto=detalle AND de.estado_idestado!=1;
 END IF;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_TodosLosDetallesEnEjecucion` (IN `orden` INT)  NO SQL
BEGIN
#Proyectos que estan en ejecucion
SELECT dp.idDetalle_proyecto,dp.negocio_idnegocio FROM detalle_proyecto dp WHERE dp.proyecto_numero_orden=orden AND dp.estado_idestado=4;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarCantidadDetalleProyecto` (IN `orden` INT, IN `detalle` INT, IN `lector` INT, IN `busqueda` INT)  NO SQL
BEGIN

DECLARE can int;
DECLARE id int;
DECLARE oper int;

IF busqueda=1 THEN

SET id=(SELECT f.cantidad_terminada from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
#Numero de operarios
SET oper=(SELECT f.noperarios FROM detalle_formato_estandar f WHERE f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=lector);

ELSE
 IF busqueda=2 THEN
 
 SET id=(SELECT f.cantidad_terminada from detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 #Numero de operarios
 SET oper=(SELECT f.noperarios FROM detalle_teclados f WHERE f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=lector);
 ELSE
  IF busqueda=3 THEN
  
  SET id=(SELECT f.cantidad_terminada from detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
  #Numero de operarios
  SET oper=(SELECT f.noperarios FROM detalle_ensamble f WHERE f.detalle_proyecto_idDetalle_proyecto=detalle and f.Procesos_idproceso=lector);
  ELSE
   SET id=(SELECT f.cantidad_recibida from almacen f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
  END IF; 
 END IF;
END IF;

set can=(select d.canitadad_total FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);

SELECT can as contidad_total,id as cantidad_proceso,oper as operarios;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarCantidadPNCOrigen` (IN `orden` INT, IN `detalle` INT, IN `op` INT, IN `tipo` INT, IN `negocio` INT)  NO SQL
BEGIN

IF op=1 THEN

 SELECT d.canitadad_total FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden and d.idDetalle_proyecto=detalle;

else

SELECT d.canitadad_total FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden and d.PNC=0 and d.negocio_idnegocio=negocio AND d.tipo_negocio_idtipo_negocio=tipo;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarDetalleProyectoQR` (IN `orden` INT, IN `area` INT, IN `producto` INT)  NO SQL
BEGIN

IF EXISTS(SELECT * FROM detalle_proyecto dp WHERE dp.proyecto_numero_orden=orden AND dp.negocio_idnegocio=area AND dp.tipo_negocio_idtipo_negocio=producto) THEN
#Si ya existe devuelva un false
SELECT 0;
ELSE
#si no existe devuelve un true 
SELECT 1;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarEstadoProyecto` (IN `detalle` INT, IN `negocio` INT)  NO SQL
BEGIN

IF EXISTS(SELECT * FROM detalle_proyecto dp WHERE dp.estado_idestado=3 AND dp.idDetalle_proyecto=detalle)  THEN

 IF negocio=1 THEN
  #Formato estandar
  SELECT df.tiempo_por_unidad FROM detalle_formato_estandar df WHERE df.detalle_proyecto_idDetalle_proyecto=detalle AND df.tiempo_por_unidad!='00:00';
 ELSE
  IF negocio=2 THEN
   #Teclados
   SELECT df.tiempo_por_unidad FROM detalle_teclados df WHERE df.detalle_proyecto_idDetalle_proyecto=detalle AND df.tiempo_por_unidad!='00:00';
   ELSE
   #Ensamble
   SELECT df.tiempo_por_unidad FROM detalle_ensamble df WHERE df.detalle_proyecto_idDetalle_proyecto=detalle AND df.tiempo_por_unidad!='00:00';
  END IF;
 END IF;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_validarPNC` (IN `orden` INT, IN `proceso` VARCHAR(30))  NO SQL
BEGIN

SELECT p.idDetalle_proyecto FROM detalle_proyecto p WHERE p.ubicacion=proceso and p.proyecto_numero_orden=orden;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarProyectoQR` (IN `orden` INT)  NO SQL
BEGIN

IF EXISTS(SELECT * FROM proyecto p WHERE p.numero_orden=orden) THEN
#Si ya existe la orden
SELECT 0;
ELSE
#La orden no existe
SELECT 1;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarUbicacionPNC` (IN `orden` INT, IN `ubicacion` VARCHAR(50), IN `detalle` INT)  NO SQL
BEGIN

IF EXISTS(SELECT * FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.PNC=1 and d.ubicacion=ubicacion AND d.idDetalle_proyecto=detalle) THEN
SELECT d.idDetalle_proyecto FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.PNC=1 and d.ubicacion=ubicacion AND d.idDetalle_proyecto=detalle;

ELSE

SELECT 0;

END IF;

END$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ActualizarEstado` (`doc` VARCHAR(13), `est` BOOLEAN) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE val varchar(13);
set val= (SELECT numero_documento from usuario where numero_documento=doc);

IF val=doc THEN
UPDATE usuario SET estado=est WHERE numero_documento=doc;
RETURN 1;
ELSE
RETURN 0;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_CambiarContraseña` (`doc` VARCHAR(13), `contra` VARCHAR(20), `anti` VARCHAR(20)) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE var varchar(20);
set var=(SELECT u.contraeña FROM usuario u WHERE u.numero_documento = doc);
IF var=anti THEN
UPDATE usuario u SET u.contraeña=contra WHERE u.numero_documento=doc;
RETURN 1;
ELSE
RETURN 0;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_EliminarDetalleProyectoAlmacen` (`iddetalle` INT, `orden` INT) RETURNS INT(11) NO SQL
BEGIN

DELETE FROM almacen WHERE detalle_proyecto_idDetalle_proyecto=iddetalle;

DELETE FROM `detalle_proyecto` WHERE idDetalle_proyecto=iddetalle;
 
CALL PA_CambiarEstadoDeProyecto(orden);

RETURN 1;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_EliminarDetalleProyectoEnsamble` (`iddetalle` INT, `orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE cantidad int;
SET cantidad=(SELECT count(*) from detalle_ensamble f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);

IF cantidad=0 THEN
DELETE FROM `detalle_ensamble` WHERE detalle_proyecto_idDetalle_proyecto=iddetalle;

DELETE FROM `detalle_proyecto` WHERE idDetalle_proyecto=iddetalle;
#CALL PA_CambiarEstadoDeProductos(3,iddetalle);
CALL PA_CambiarEstadoDeProyecto(orden);
RETURN 1;
ELSE
RETURN 0;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_EliminarDetalleProyectoFormatoestandar` (`iddetalle` INT, `orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE cantidad int;
SET cantidad=(SELECT count(*) from detalle_formato_estandar f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);

IF cantidad=0 THEN
DELETE FROM `detalle_formato_estandar` WHERE detalle_proyecto_idDetalle_proyecto=iddetalle;

DELETE FROM `detalle_proyecto` WHERE idDetalle_proyecto=iddetalle;
#CALL PA_CambiarEstadoDeProductos(1,iddetalle);
CALL PA_CambiarEstadoDeProyecto(orden);
RETURN 1;
ELSE
RETURN 0;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_EliminarDetalleProyectoTeclados` (`iddetalle` INT, `orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE cantidad int;
SET cantidad=(SELECT count(*) from detalle_teclados f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);

IF cantidad=0 THEN
DELETE FROM `detalle_teclados` WHERE detalle_proyecto_idDetalle_proyecto=iddetalle;

DELETE FROM `detalle_proyecto` WHERE idDetalle_proyecto=iddetalle;
#CALL PA_CambiarEstadoDeProductos(2,iddetalle);
CALL PA_CambiarEstadoDeProyecto(orden);
RETURN 1;
ELSE
RETURN 0;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_EstadoDeProyecto` (`orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN

IF EXISTS(SELECT * FROM proyecto p WHERE p.numero_orden=orden
         AND p.estado_idestado!=4) THEN
         #Se puede modificar el estado del proyecto
RETURN 1;

ELSE
	# No se puede modificar el estado del proyecto
RETURN 0;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_IniciarSesion` (`usuario` VARCHAR(13), `pasw` VARCHAR(20)) RETURNS TINYINT(2) NO SQL
BEGIN
DECLARE val varchar(13);
DECLARE car int;
SET val=(SELECT u.numero_documento from usuario u WHERE u.numero_documento=usuario AND u.contraeña= pasw AND estado=1);
if val!='' THEN
set car=(SELECT cargo_idcargo FROM usuario WHERE numero_documento = usuario);
  RETURN car;
ELSE
  RETURN 0;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_InsertarModificarUsuar` (`_doc` VARCHAR(13), `_tipo` VARCHAR(3), `_nombre` VARCHAR(30), `_apellido` VARCHAR(30), `_cargo` TINYINT, `_estado` TINYINT, `op` TINYINT, `rec` VARCHAR(10)) RETURNS TINYINT(1) READS SQL DATA
BEGIN
 DECLARE val varchar(13);
if op=1 THEN
SET val=(SELECT numero_documento FROM usuario WHERE    numero_documento=_doc);
  IF val=_doc THEN
     RETURN 0;
 ELSE 
     INSERT INTO        usuario(numero_documento,tipo_documento,nombres,apellidos,cargo_idcargo,estado,contraeña,recuperacion)   VALUES (_doc,_tipo,_nombre,_apellido,_cargo,_estado,_doc,rec);
  return 1;
  
END IF;
ELSE
UPDATE usuario SET tipo_documento=_tipo,nombres=_nombre, apellidos=_apellido, cargo_idcargo=_cargo,estado=_estado where  numero_documento=_doc;
RETURN 1;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ModificarDetalleProyecto` (`orden` INT, `idDetalle` INT, `cantidad` VARCHAR(6), `material` VARCHAR(6), `negocio` INT, `ubicacion` VARCHAR(25)) RETURNS TINYINT(1) NO SQL
BEGIN
UPDATE detalle_proyecto dp SET dp.canitadad_total=cantidad,dp.material=material,dp.ubicacion=ubicacion WHERE idDetalle_proyecto=idDetalle and proyecto_numero_orden=orden;
#Valida el cambio de estado...
CALL PA_CambiarEstadoDeProductos(negocio,idDetalle);
RETURN 1;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_RegistrarDetalleProyecto` (`orden` INT(11), `tipoNegocio` VARCHAR(20), `cantidad` VARCHAR(6), `negocio` VARCHAR(20), `estado` TINYINT(1), `material` VARCHAR(6), `pnc` TINYINT(1), `ubic` VARCHAR(30)) RETURNS TINYINT(1) NO SQL
BEGIN
IF material != '' THEN
INSERT INTO `detalle_proyecto`(`tipo_negocio_idtipo_negocio`, `canitadad_total`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`,`material`,`PNC`,`ubicacion`) VALUES ((SELECT idtipo_negocio from tipo_negocio where nombre =tipoNegocio),cantidad,orden,(SELECT idnegocio FROM negocio WHERE nom_negocio =negocio),estado,material,pnc,ubic);
RETURN 1;
ELSE
INSERT INTO `detalle_proyecto`(`tipo_negocio_idtipo_negocio`, `canitadad_total`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`,`PNC`,`ubicacion`) VALUES ((SELECT idtipo_negocio from tipo_negocio where nombre =tipoNegocio),cantidad,orden,(SELECT idnegocio FROM negocio WHERE nom_negocio =negocio),estado,pnc,ubic);
RETURN 1;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_RegistrarModificarProyecto` (`doc` VARCHAR(13), `cliente` VARCHAR(150), `proyecto` VARCHAR(150), `tipo` VARCHAR(6), `fe` TINYINT(1), `te` TINYINT(1), `inte` TINYINT(1), `pcbfe` TINYINT(1), `pcbte` TINYINT(1), `conv` TINYINT(1), `rep` TINYINT(1), `tro` TINYINT(1), `st` TINYINT(1), `lexan` TINYINT(1), `entrega` VARCHAR(11), `ruteo` TINYINT(1), `anti` TINYINT(1), `norden` INT, `op` TINYINT(1), `ruteoP` TINYINT(1), `antiP` TINYINT(1), `fecha1` VARCHAR(11), `fecha2` VARCHAR(11), `fecha3` VARCHAR(11), `fecha4` VARCHAR(11)) RETURNS TINYINT(11) NO SQL
IF op=1 THEN

INSERT INTO `proyecto`(`numero_orden`,`usuario_numero_documento`, `nombre_cliente`, `nombre_proyecto`, `tipo_proyecto`, `FE`, `TE`, `IN`, `pcb_FE`, `pcb_TE`, `Conversor`, `Repujado`, `troquel`, `stencil`, `lexan`, `fecha_ingreso`, `fecha_entrega`, `ruteoC`, `antisolderC`, `estado_idestado`,`ruteoP`,`antisolderP`,`entregaCircuitoFEoGF`,`entregaCOMCircuito`,`entregaPCBFEoGF`,`entregaPCBCom`) VALUES (norden,doc,cliente,proyecto,tipo,fe,te,inte,pcbfe,pcbte,conv,rep,tro,st,lexan,(SELECT now()),entrega,ruteo,anti,1,ruteoP,antiP,fecha1,fecha2,fecha3,fecha4); 
RETURN 1;
ELSE 
 UPDATE `proyecto` SET `nombre_cliente`=cliente,`nombre_proyecto`=proyecto,`tipo_proyecto`=tipo,`FE`=fe,`TE`=te,`IN`=inte,`pcb_FE`=pcbfe,`pcb_TE`=pcbte,`Conversor`=conv,`Repujado`=rep,`troquel`=tro,`stencil`=st,`lexan`=lexan,`fecha_entrega`=entrega,`ruteoC`=ruteo,`antisolderC`=anti,`ruteoP`=ruteoP,`antisolderP`=antiP,`entregaCircuitoFEoGF`=fecha1,`entregaCOMCircuito`=fecha2,`entregaPCBFEoGF`=fecha3,`entregaPCBCom`=fecha4 WHERE numero_orden=norden;
RETURN 1;
END IF$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ReiniciarTiempo` (`detalle` INT, `negocio` INT) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE cantidadp int;
DECLARE detalleN int;


IF negocio=1 THEN
#Formato estandar
UPDATE `detalle_formato_estandar` SET `tiempo_por_unidad`= "00:00",`tiempo_total_por_proceso`="00:00",`cantidad_terminada`=0,`fecha_inicio`=null,`fecha_fin`=null,`estado_idestado`=1,`hora_ejecucion`=null,`hora_terminacion`=null WHERE `idDetalle_formato_estandar`=detalle;
#Se actualizan la cantidad de proyectos que estan en diferentes estados de los proyectos de FE
SET detalleN =(SELECT d.detalle_proyecto_idDetalle_proyecto FROM detalle_formato_estandar d WHERE d.idDetalle_formato_estandar=detalle);

 SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalleN;
#Se cambia del detalle del proyecto
CALL PA_CambiarEstadoDeProductos(negocio,detalleN);
  RETURN 1;
ELSE
 IF negocio=2 THEN
 #Teclados
UPDATE `detalle_teclados` SET `tiempo_por_unidad`= "00:00",`tiempo_total_proceso`="00:00",`cantidad_terminada`=0,`fecha_inicio`=null,`fecha_fin`=null,`estado_idestado`=1,`hora_ejecucion`=null,`hora_terminacion`=null WHERE `idDetalle_teclados`=detalle;
#Se actualizan la cantidad de proyectos que estan en diferentes estados de los proyectos de TE
SET detalleN =(SELECT d.detalle_proyecto_idDetalle_proyecto FROM detalle_teclados d WHERE d.idDetalle_teclados=detalle);

 SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalleN;
#Se cambia del detalle del proyecto
CALL PA_CambiarEstadoDeProductos(negocio,detalleN);
 RETURN 1;
 ELSE
  #Ensamble
UPDATE `detalle_ensamble` SET `tiempo_por_unidad`= "00:00",`tiempo_total_por_proceso`="00:00",`cantidad_terminada`=0,`fecha_inicio`=null,`fecha_fin`=null,`estado_idestado`=1,`hora_ejecucion`=null,`hora_terminacion`=null WHERE `idDetalle_ensamble`=detalle;
#Se actualizan la cantidad de proyectos que estan en diferentes estados de los proyectos de EN
SET detalleN =(SELECT d.detalle_proyecto_idDetalle_proyecto FROM detalle_ensamble d WHERE d.idDetalle_ensamble=detalle);

 SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalleN;

#Se cambia del detalle del proyecto
CALL PA_CambiarEstadoDeProductos(negocio,detalleN);
  RETURN 1;
 END IF;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_validarActividad` (`doc` VARCHAR(13)) RETURNS INT(11) NO SQL
BEGIN

IF EXISTS(SELECT u.numero_documento from usuario u WHERE u.numero_documento=doc and u.sesion=1) THEN
RETURN 1;
ELSE
RETURN 0;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_validarEliminacion` (`iddetalle` INT, `orden` INT, `tipo` INT, `busqueda` INT) RETURNS TINYINT(1) NO SQL
BEGIN
#Variables
DECLARE cantidad int;

IF busqueda=1 THEN
 #Formato estandar
 SET cantidad=(SELECT count(*) from detalle_formato_estandar f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);   
IF cantidad=0 THEN
RETURN 1;
ELSE
RETURN 0;
END IF;
 #Fin de formato estandar
ELSE
 IF busqueda=2 THEN
 #Teclados
SET cantidad=(SELECT count(*) from detalle_teclados f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);
IF cantidad=0 THEN
RETURN 1;
ELSE
RETURN 0;
END IF;
 #Fin de teclados
 ELSE
  IF busqueda=3 THEN
  #Ensamble
  SET cantidad=(SELECT count(*) from detalle_ensamble f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);

IF cantidad=0 THEN
RETURN 1;
ELSE
RETURN 0;
END IF;
  #Fin de ensamble
  END IF;
 END if;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ValidarEstadoEliminado` (`orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN

IF EXISTS(SELECT * FROM proyecto p WHERE p.numero_orden=orden AND p.eliminacion=1) THEN
#Si el proyecto no esta eliminado retorna un true.
RETURN 1;
ELSE
#Si el proyecto esta eliminado retorna un false
RETURN 0;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ValidarEstadoProyectoEjecucionOParada` (`orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN

IF EXISTS(SELECT * FROM proyecto p WHERE p.numero_orden=orden AND p.parada=1) THEN
#No esta parada
RETURN 1;
ELSE
#Esta parada
return 0;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ValidarNumerOrden` (`orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN

IF EXISTS(SELECT * FROM proyecto d WHERE d.numero_orden=orden) THEN
# si el proyecto con ese numero de orden existe retorna un true
RETURN 1;
ELSE
# si el proyecto con ese numero de orden no existe retorna un false
RETURN 0;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ValidarTomaDeTiempo` (`orden` INT, `detalle` INT, `lector` INT, `busqueda` INT) RETURNS TINYINT(1) NO SQL
BEGIN

DECLARE id int;

IF busqueda=1 THEN
SET id=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
ELSE
  IF busqueda=2 THEN
SET id=(SELECT f.idDetalle_teclados from 
detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
  ELSE 
    IF busqueda=3 THEN
    SET id=(SELECT f.idDetalle_ensamble from 
detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
    END IF;
  END IF;
END IF;

IF id !='null' THEN
RETURN 1;
ELSE
RETURN 0;
END IF;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `idalmacen` smallint(6) NOT NULL,
  `tiempo_total_proceso` varchar(20) DEFAULT NULL,
  `cantidad_recibida` varchar(7) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL,
  `hora_registro` time DEFAULT NULL,
  `hora_llegada` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`idalmacen`, `tiempo_total_proceso`, `cantidad_recibida`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`, `hora_registro`, `hora_llegada`) VALUES
(45, '0', '0', '2018-01-19', '2018-01-19', 546, 23, 3, '07:55:14', '09:54:13'),
(46, '0', '12', '2018-01-22', '2018-01-22', 547, 22, 3, '09:07:34', '09:08:47'),
(47, '1', '0', '2018-01-22', '2018-01-23', 548, 23, 3, '09:27:10', '07:46:53'),
(48, '1', '0', '2018-01-22', '2018-01-23', 549, 23, 3, '09:27:10', '07:46:39');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `idcargo` tinyint(4) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`idcargo`, `nombre`) VALUES
(1, 'Gestor Comercial'),
(2, 'Encargado de FE y TE'),
(3, 'Encargado de EN'),
(4, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ensamble`
--

CREATE TABLE `detalle_ensamble` (
  `idDetalle_ensamble` smallint(6) NOT NULL,
  `tiempo_por_unidad` varchar(6) DEFAULT NULL,
  `tiempo_total_por_proceso` varchar(10) DEFAULT '00:00',
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL,
  `hora_ejecucion` time DEFAULT NULL,
  `hora_terminacion` time DEFAULT NULL,
  `restantes` int(6) NOT NULL DEFAULT '0',
  `noperarios` tinyint(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_ensamble`
--

INSERT INTO `detalle_ensamble` (`idDetalle_ensamble`, `tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`, `hora_ejecucion`, `hora_terminacion`, `restantes`, `noperarios`) VALUES
(1, '00:00', '00:00', '0', NULL, NULL, 557, 15, 1, NULL, NULL, 0, 0),
(2, '00:00', '00:00', '0', NULL, NULL, 557, 16, 1, NULL, NULL, 0, 0),
(3, '00:00', '00:00', '0', NULL, NULL, 557, 17, 1, NULL, NULL, 0, 0),
(4, '00:00', '00:00', '0', NULL, NULL, 557, 18, 1, NULL, NULL, 0, 0),
(5, '00:00', '00:00', '0', NULL, NULL, 557, 19, 1, NULL, NULL, 0, 0),
(6, '00:00', '00:00', '0', NULL, NULL, 557, 20, 1, NULL, NULL, 0, 0),
(7, '00:00', '00:00', '0', NULL, NULL, 557, 21, 1, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_formato_estandar`
--

CREATE TABLE `detalle_formato_estandar` (
  `idDetalle_formato_estandar` smallint(6) NOT NULL,
  `tiempo_por_unidad` varchar(6) DEFAULT NULL,
  `tiempo_total_por_proceso` varchar(10) DEFAULT '00:00',
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL,
  `hora_ejecucion` time DEFAULT NULL,
  `hora_terminacion` time DEFAULT NULL,
  `restantes` int(6) NOT NULL DEFAULT '0',
  `noperarios` tinyint(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_formato_estandar`
--

INSERT INTO `detalle_formato_estandar` (`idDetalle_formato_estandar`, `tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`, `hora_ejecucion`, `hora_terminacion`, `restantes`, `noperarios`) VALUES
(1623, '05:09', '128:53', '25', '2018-01-15', '2018-01-15', 458, 1, 3, '08:38:00', '10:46:53', 0, 0),
(1624, '05:07', '128:11', '25', '2018-01-15', '2018-01-15', 458, 2, 3, '08:38:45', '10:46:56', 0, 0),
(1625, '03:48', '95:18', '25', '2018-01-15', '2018-01-15', 458, 3, 3, '08:39:06', '10:14:24', 0, 0),
(1626, '02:37', '65:42', '25', '2018-01-15', '2018-01-15', 458, 4, 3, '08:39:10', '09:44:52', 0, 0),
(1627, '02:41', '67:26', '25', '2018-01-15', '2018-01-15', 458, 5, 3, '08:39:15', '09:46:41', 0, 0),
(1628, '15:27', '386:33', '25', '2018-01-15', '2018-01-15', 458, 6, 3, '08:40:27', '15:07:00', 0, 0),
(1629, '01:52', '46:44', '25', '2018-01-15', '2018-01-15', 458, 7, 3, '15:29:02', '16:15:46', 0, 0),
(1630, '02:02', '50:53', '25', '2018-01-15', '2018-01-16', 458, 8, 3, '07:49:04', '07:50:25', 0, 0),
(1631, '00:00', '11:15', '2', '2018-01-17', NULL, 458, 9, 2, '15:30:45', '15:30:48', 23, 0),
(1632, '00:00', '00:00', '0', NULL, NULL, 458, 10, 1, NULL, NULL, 25, 0),
(1827, '00:00', '00:00', '0', NULL, NULL, 533, 1, 1, NULL, NULL, 0, 0),
(1828, '00:00', '00:00', '0', NULL, NULL, 533, 2, 1, NULL, NULL, 0, 0),
(1829, '00:00', '00:00', '0', NULL, NULL, 533, 3, 1, NULL, NULL, 0, 0),
(1830, '00:00', '00:00', '0', NULL, NULL, 533, 4, 1, NULL, NULL, 0, 0),
(1831, '00:00', '00:00', '0', NULL, NULL, 533, 5, 1, NULL, NULL, 0, 0),
(1832, '00:00', '00:00', '0', NULL, NULL, 533, 7, 1, NULL, NULL, 0, 0),
(1833, '00:00', '00:00', '0', NULL, NULL, 533, 8, 1, NULL, NULL, 0, 0),
(1834, '00:00', '00:00', '0', NULL, NULL, 533, 10, 1, NULL, NULL, 0, 0),
(1835, '00:00', '00:00', '0', NULL, NULL, 534, 1, 1, NULL, NULL, 0, 0),
(1836, '00:00', '00:00', '0', NULL, NULL, 534, 2, 1, NULL, NULL, 0, 0),
(1837, '00:00', '00:00', '0', NULL, NULL, 534, 3, 1, NULL, NULL, 0, 0),
(1838, '00:00', '00:00', '0', NULL, NULL, 534, 4, 1, NULL, NULL, 0, 0),
(1839, '00:00', '00:00', '0', NULL, NULL, 534, 5, 1, NULL, NULL, 0, 0),
(1840, '00:00', '00:00', '0', NULL, NULL, 534, 6, 1, NULL, NULL, 0, 0),
(1841, '00:00', '00:00', '0', NULL, NULL, 534, 7, 1, NULL, NULL, 0, 0),
(1842, '00:00', '00:00', '0', NULL, NULL, 534, 8, 1, NULL, NULL, 0, 0),
(1843, '00:00', '00:00', '0', NULL, NULL, 534, 9, 1, NULL, NULL, 0, 0),
(1844, '00:00', '00:00', '0', NULL, NULL, 534, 10, 1, NULL, NULL, 0, 0),
(1845, '00:00', '00:00', '0', NULL, NULL, 535, 1, 1, NULL, NULL, 0, 0),
(1846, '00:00', '00:00', '0', NULL, NULL, 535, 2, 1, NULL, NULL, 0, 0),
(1847, '00:00', '00:00', '0', NULL, NULL, 535, 3, 1, NULL, NULL, 0, 0),
(1848, '00:00', '00:00', '0', NULL, NULL, 535, 4, 1, NULL, NULL, 0, 0),
(1849, '00:00', '00:00', '0', NULL, NULL, 535, 5, 1, NULL, NULL, 0, 0),
(1850, '00:00', '00:00', '0', NULL, NULL, 535, 7, 1, NULL, NULL, 0, 0),
(1851, '00:00', '00:00', '0', NULL, NULL, 535, 8, 1, NULL, NULL, 0, 0),
(1852, '00:00', '00:00', '0', NULL, NULL, 535, 10, 1, NULL, NULL, 0, 0),
(1885, '00:00', '00:00', '0', NULL, NULL, 545, 1, 1, NULL, NULL, 0, 0),
(1886, '00:00', '00:00', '0', NULL, NULL, 545, 2, 1, NULL, NULL, 0, 0),
(1887, '00:00', '00:00', '0', NULL, NULL, 545, 3, 1, NULL, NULL, 0, 0),
(1888, '00:00', '00:00', '0', NULL, NULL, 545, 4, 1, NULL, NULL, 0, 0),
(1889, '00:00', '00:00', '0', NULL, NULL, 545, 5, 1, NULL, NULL, 0, 0),
(1890, '00:00', '00:00', '0', NULL, NULL, 545, 7, 1, NULL, NULL, 0, 0),
(1891, '00:00', '00:00', '0', NULL, NULL, 545, 8, 1, NULL, NULL, 0, 0),
(1892, '00:00', '00:00', '0', NULL, NULL, 545, 10, 1, NULL, NULL, 0, 0),
(1893, '00:00', '00:00', '0', NULL, NULL, 550, 1, 1, NULL, NULL, 0, 0),
(1894, '00:00', '00:00', '0', NULL, NULL, 550, 3, 1, NULL, NULL, 0, 0),
(1895, '00:00', '00:00', '0', NULL, NULL, 550, 4, 1, NULL, NULL, 0, 0),
(1896, '00:00', '00:00', '0', NULL, NULL, 550, 5, 1, NULL, NULL, 0, 0),
(1897, '00:00', '00:00', '0', NULL, NULL, 550, 7, 1, NULL, NULL, 0, 0),
(1898, '00:00', '00:00', '0', NULL, NULL, 550, 8, 1, NULL, NULL, 0, 0),
(1899, '00:00', '00:00', '0', NULL, NULL, 550, 9, 1, NULL, NULL, 0, 0),
(1900, '00:00', '00:00', '0', NULL, NULL, 550, 10, 1, NULL, NULL, 0, 0),
(1901, '00:00', '00:00', '0', NULL, NULL, 551, 1, 1, NULL, NULL, 0, 0),
(1902, '00:00', '00:00', '0', NULL, NULL, 551, 4, 1, NULL, NULL, 0, 0),
(1903, '00:00', '00:00', '0', NULL, NULL, 552, 1, 1, NULL, NULL, 0, 0),
(1904, '00:00', '00:00', '0', NULL, NULL, 552, 4, 1, NULL, NULL, 0, 0),
(1905, '00:00', '00:00', '0', NULL, NULL, 553, 1, 1, NULL, NULL, 0, 0),
(1922, '00:00', '00:00', '0', NULL, NULL, 560, 1, 1, NULL, NULL, 0, 0),
(1923, '00:00', '00:00', '0', NULL, NULL, 560, 2, 1, NULL, NULL, 0, 0),
(1924, '00:00', '00:00', '0', NULL, NULL, 560, 3, 1, NULL, NULL, 0, 0),
(1925, '00:00', '00:00', '0', NULL, NULL, 560, 4, 1, NULL, NULL, 0, 0),
(1926, '00:00', '00:00', '0', NULL, NULL, 560, 5, 1, NULL, NULL, 0, 0),
(1927, '00:00', '00:00', '0', NULL, NULL, 560, 7, 1, NULL, NULL, 0, 0),
(1928, '00:00', '00:00', '0', NULL, NULL, 560, 8, 1, NULL, NULL, 0, 0),
(1929, '00:00', '00:00', '0', NULL, NULL, 560, 10, 1, NULL, NULL, 0, 0),
(1930, '00:00', '00:00', '0', NULL, NULL, 561, 1, 1, NULL, NULL, 0, 0),
(1931, '00:00', '00:00', '0', NULL, NULL, 561, 2, 1, NULL, NULL, 0, 0),
(1932, '00:00', '00:00', '0', NULL, NULL, 561, 3, 1, NULL, NULL, 0, 0),
(1933, '00:00', '00:00', '0', NULL, NULL, 561, 4, 1, NULL, NULL, 0, 0),
(1934, '00:00', '00:00', '0', NULL, NULL, 561, 5, 1, NULL, NULL, 0, 0),
(1935, '00:00', '00:00', '0', NULL, NULL, 561, 7, 1, NULL, NULL, 0, 0),
(1936, '00:00', '00:00', '0', NULL, NULL, 561, 8, 1, NULL, NULL, 0, 0),
(1937, '00:00', '00:00', '0', NULL, NULL, 561, 10, 1, NULL, NULL, 0, 0),
(1938, '00:00', '00:00', '0', NULL, NULL, 562, 1, 1, NULL, NULL, 0, 0),
(1939, '00:00', '00:00', '0', NULL, NULL, 562, 3, 1, NULL, NULL, 0, 0),
(1940, '00:00', '00:00', '0', NULL, NULL, 562, 4, 1, NULL, NULL, 0, 0),
(1941, '00:00', '00:00', '0', NULL, NULL, 562, 5, 1, NULL, NULL, 0, 0),
(1942, '00:00', '00:00', '0', NULL, NULL, 562, 7, 1, NULL, NULL, 0, 0),
(1943, '00:00', '00:00', '0', NULL, NULL, 562, 8, 1, NULL, NULL, 0, 0),
(1944, '00:00', '00:00', '0', NULL, NULL, 562, 10, 1, NULL, NULL, 0, 0),
(1945, '00:00', '00:00', '0', NULL, NULL, 563, 1, 1, NULL, NULL, 0, 0),
(1946, '00:00', '00:00', '0', NULL, NULL, 563, 2, 1, NULL, NULL, 0, 0),
(1947, '00:00', '00:00', '0', NULL, NULL, 563, 3, 1, NULL, NULL, 0, 0),
(1948, '00:00', '00:00', '0', NULL, NULL, 563, 4, 1, NULL, NULL, 0, 0),
(1949, '00:00', '00:00', '0', NULL, NULL, 563, 5, 1, NULL, NULL, 0, 0),
(1950, '00:00', '00:00', '0', NULL, NULL, 563, 7, 1, NULL, NULL, 0, 0),
(1951, '00:00', '00:00', '0', NULL, NULL, 563, 8, 1, NULL, NULL, 0, 0),
(1952, '00:00', '00:00', '0', NULL, NULL, 563, 10, 1, NULL, NULL, 0, 0),
(1953, '00:00', '00:00', '0', NULL, NULL, 564, 1, 1, NULL, NULL, 0, 0),
(1954, '00:00', '00:00', '0', NULL, NULL, 564, 3, 1, NULL, NULL, 0, 0),
(1955, '00:00', '00:00', '0', NULL, NULL, 564, 4, 1, NULL, NULL, 0, 0),
(1956, '00:00', '00:00', '0', NULL, NULL, 564, 5, 1, NULL, NULL, 0, 0),
(1957, '00:00', '00:00', '0', NULL, NULL, 564, 7, 1, NULL, NULL, 0, 0),
(1958, '00:00', '00:00', '0', NULL, NULL, 564, 8, 1, NULL, NULL, 0, 0),
(1959, '00:00', '00:00', '0', NULL, NULL, 564, 10, 1, NULL, NULL, 0, 0),
(1960, '00:00', '00:00', '0', NULL, NULL, 565, 1, 1, NULL, NULL, 0, 0),
(1961, '00:00', '00:00', '0', NULL, NULL, 565, 2, 1, NULL, NULL, 0, 0),
(1962, '00:00', '00:00', '0', NULL, NULL, 565, 3, 1, NULL, NULL, 0, 0),
(1963, '00:00', '00:00', '0', NULL, NULL, 565, 4, 1, NULL, NULL, 0, 0),
(1964, '00:00', '00:00', '0', NULL, NULL, 565, 5, 1, NULL, NULL, 0, 0),
(1965, '00:00', '00:00', '0', NULL, NULL, 565, 6, 1, NULL, NULL, 0, 0),
(1966, '00:00', '00:00', '0', NULL, NULL, 565, 7, 1, NULL, NULL, 0, 0),
(1967, '00:00', '00:00', '0', NULL, NULL, 565, 8, 1, NULL, NULL, 0, 0),
(1968, '00:00', '00:00', '0', NULL, NULL, 565, 10, 1, NULL, NULL, 0, 0),
(1969, '00:00', '00:00', '0', NULL, NULL, 566, 1, 1, NULL, NULL, 0, 0),
(1970, '00:00', '00:00', '0', NULL, NULL, 566, 2, 1, NULL, NULL, 0, 0),
(1971, '00:00', '00:00', '0', NULL, NULL, 566, 3, 1, NULL, NULL, 0, 0),
(1972, '00:00', '00:00', '0', NULL, NULL, 566, 4, 1, NULL, NULL, 0, 0),
(1973, '00:00', '00:00', '0', NULL, NULL, 566, 5, 1, NULL, NULL, 0, 0),
(1974, '00:00', '00:00', '0', NULL, NULL, 566, 7, 1, NULL, NULL, 0, 0),
(1975, '00:00', '00:00', '0', NULL, NULL, 566, 8, 1, NULL, NULL, 0, 0),
(1976, '00:00', '00:00', '0', NULL, NULL, 566, 9, 1, NULL, NULL, 0, 0),
(1977, '00:00', '00:00', '0', NULL, NULL, 566, 10, 1, NULL, NULL, 0, 0),
(1978, '00:00', '00:00', '0', NULL, NULL, 567, 1, 1, NULL, NULL, 0, 0),
(1979, '00:00', '00:00', '0', NULL, NULL, 567, 3, 1, NULL, NULL, 0, 0),
(1980, '00:00', '00:00', '0', NULL, NULL, 567, 4, 1, NULL, NULL, 0, 0),
(1981, '00:00', '00:00', '0', NULL, NULL, 567, 5, 1, NULL, NULL, 0, 0),
(1982, '00:00', '00:00', '0', NULL, NULL, 567, 7, 1, NULL, NULL, 0, 0),
(1983, '00:00', '00:00', '0', NULL, NULL, 567, 8, 1, NULL, NULL, 0, 0),
(1984, '00:00', '00:00', '0', NULL, NULL, 567, 10, 1, NULL, NULL, 0, 0),
(1985, '00:00', '00:00', '0', NULL, NULL, 568, 1, 1, NULL, NULL, 0, 0),
(1986, '00:00', '00:00', '0', NULL, NULL, 568, 2, 1, NULL, NULL, 0, 0),
(1987, '00:00', '00:00', '0', NULL, NULL, 568, 3, 1, NULL, NULL, 0, 0),
(1988, '00:00', '00:00', '0', NULL, NULL, 568, 4, 1, NULL, NULL, 0, 0),
(1989, '00:00', '00:00', '0', NULL, NULL, 568, 5, 1, NULL, NULL, 0, 0),
(1990, '00:00', '00:00', '0', NULL, NULL, 568, 7, 1, NULL, NULL, 0, 0),
(1991, '00:00', '00:00', '0', NULL, NULL, 568, 8, 1, NULL, NULL, 0, 0),
(1992, '00:00', '00:00', '0', NULL, NULL, 568, 10, 1, NULL, NULL, 0, 0),
(1993, '00:00', '00:00', '0', NULL, NULL, 569, 1, 1, NULL, NULL, 0, 0),
(1994, '00:00', '00:00', '0', NULL, NULL, 569, 3, 1, NULL, NULL, 0, 0),
(1995, '00:00', '00:00', '0', NULL, NULL, 569, 4, 1, NULL, NULL, 0, 0),
(1996, '00:00', '00:00', '0', NULL, NULL, 569, 5, 1, NULL, NULL, 0, 0),
(1997, '00:00', '00:00', '0', NULL, NULL, 569, 7, 1, NULL, NULL, 0, 0),
(1998, '00:00', '00:00', '0', NULL, NULL, 569, 8, 1, NULL, NULL, 0, 0),
(1999, '00:00', '00:00', '0', NULL, NULL, 569, 10, 1, NULL, NULL, 0, 0),
(2000, '00:00', '00:00', '0', NULL, NULL, 570, 1, 1, NULL, NULL, 0, 0),
(2001, '00:00', '00:00', '0', NULL, NULL, 570, 3, 1, NULL, NULL, 0, 0),
(2002, '00:00', '00:00', '0', NULL, NULL, 570, 4, 1, NULL, NULL, 0, 0),
(2003, '00:00', '00:00', '0', NULL, NULL, 570, 5, 1, NULL, NULL, 0, 0),
(2004, '00:00', '00:00', '0', NULL, NULL, 570, 7, 1, NULL, NULL, 0, 0),
(2005, '00:00', '00:00', '0', NULL, NULL, 570, 8, 1, NULL, NULL, 0, 0),
(2006, '00:00', '00:00', '0', NULL, NULL, 570, 10, 1, NULL, NULL, 0, 0),
(2007, '00:00', '00:00', '0', NULL, NULL, 571, 1, 1, NULL, NULL, 0, 0),
(2008, '00:00', '00:00', '0', NULL, NULL, 571, 2, 1, NULL, NULL, 0, 0),
(2009, '00:00', '00:00', '0', NULL, NULL, 571, 3, 1, NULL, NULL, 0, 0),
(2010, '00:00', '00:00', '0', NULL, NULL, 571, 4, 1, NULL, NULL, 0, 0),
(2011, '00:00', '00:00', '0', NULL, NULL, 571, 5, 1, NULL, NULL, 0, 0),
(2012, '00:00', '00:00', '0', NULL, NULL, 571, 7, 1, NULL, NULL, 0, 0),
(2013, '00:00', '00:00', '0', NULL, NULL, 571, 8, 1, NULL, NULL, 0, 0),
(2014, '00:00', '00:00', '0', NULL, NULL, 571, 10, 1, NULL, NULL, 0, 0),
(2015, '00:00', '00:00', '0', NULL, NULL, 572, 1, 1, NULL, NULL, 0, 0),
(2016, '00:00', '00:00', '0', NULL, NULL, 572, 2, 1, NULL, NULL, 0, 0),
(2017, '00:00', '00:00', '0', NULL, NULL, 572, 3, 1, NULL, NULL, 0, 0),
(2018, '00:00', '00:00', '0', NULL, NULL, 572, 4, 1, NULL, NULL, 0, 0),
(2019, '00:00', '00:00', '0', NULL, NULL, 572, 5, 1, NULL, NULL, 0, 0),
(2020, '00:00', '00:00', '0', NULL, NULL, 572, 7, 1, NULL, NULL, 0, 0),
(2021, '00:00', '00:00', '0', NULL, NULL, 572, 8, 1, NULL, NULL, 0, 0),
(2022, '00:00', '00:00', '0', NULL, NULL, 572, 10, 1, NULL, NULL, 0, 0),
(2023, '00:00', '00:00', '0', NULL, NULL, 573, 1, 1, NULL, NULL, 0, 0),
(2024, '00:00', '00:00', '0', NULL, NULL, 573, 3, 1, NULL, NULL, 0, 0),
(2025, '00:00', '00:00', '0', NULL, NULL, 573, 4, 1, NULL, NULL, 0, 0),
(2026, '00:00', '00:00', '0', NULL, NULL, 573, 5, 1, NULL, NULL, 0, 0),
(2027, '00:00', '00:00', '0', NULL, NULL, 573, 7, 1, NULL, NULL, 0, 0),
(2028, '00:00', '00:00', '0', NULL, NULL, 573, 8, 1, NULL, NULL, 0, 0),
(2029, '00:00', '00:00', '0', NULL, NULL, 573, 10, 1, NULL, NULL, 0, 0),
(2030, '00:00', '00:00', '0', NULL, NULL, 574, 1, 1, NULL, NULL, 0, 0),
(2031, '00:00', '00:00', '0', NULL, NULL, 574, 2, 1, NULL, NULL, 0, 0),
(2032, '00:00', '00:00', '0', NULL, NULL, 574, 3, 1, NULL, NULL, 0, 0),
(2033, '00:00', '00:00', '0', NULL, NULL, 574, 4, 1, NULL, NULL, 0, 0),
(2034, '00:00', '00:00', '0', NULL, NULL, 574, 5, 1, NULL, NULL, 0, 0),
(2035, '00:00', '00:00', '0', NULL, NULL, 574, 7, 1, NULL, NULL, 0, 0),
(2036, '00:00', '00:00', '0', NULL, NULL, 574, 8, 1, NULL, NULL, 0, 0),
(2037, '00:00', '00:00', '0', NULL, NULL, 574, 10, 1, NULL, NULL, 0, 0),
(2038, '00:00', '00:00', '0', NULL, NULL, 575, 1, 1, NULL, NULL, 0, 0),
(2039, '00:00', '00:00', '0', NULL, NULL, 575, 2, 1, NULL, NULL, 0, 0),
(2040, '00:00', '00:00', '0', NULL, NULL, 575, 3, 1, NULL, NULL, 0, 0),
(2041, '00:00', '00:00', '0', NULL, NULL, 575, 4, 1, NULL, NULL, 0, 0),
(2042, '00:00', '00:00', '0', NULL, NULL, 575, 5, 1, NULL, NULL, 0, 0),
(2043, '00:00', '00:00', '0', NULL, NULL, 575, 7, 1, NULL, NULL, 0, 0),
(2044, '00:00', '00:00', '0', NULL, NULL, 575, 8, 1, NULL, NULL, 0, 0),
(2045, '00:00', '00:00', '0', NULL, NULL, 575, 10, 1, NULL, NULL, 0, 0),
(2046, '00:00', '00:00', '0', NULL, NULL, 576, 1, 1, NULL, NULL, 0, 0),
(2047, '00:00', '00:00', '0', NULL, NULL, 576, 2, 1, NULL, NULL, 0, 0),
(2048, '00:00', '00:00', '0', NULL, NULL, 576, 3, 1, NULL, NULL, 0, 0),
(2049, '00:00', '00:00', '0', NULL, NULL, 576, 4, 1, NULL, NULL, 0, 0),
(2050, '00:00', '00:00', '0', NULL, NULL, 576, 5, 1, NULL, NULL, 0, 0),
(2051, '00:00', '00:00', '0', NULL, NULL, 576, 7, 1, NULL, NULL, 0, 0),
(2052, '00:00', '00:00', '0', NULL, NULL, 576, 8, 1, NULL, NULL, 0, 0),
(2053, '00:00', '00:00', '0', NULL, NULL, 576, 10, 1, NULL, NULL, 0, 0),
(2054, '00:00', '00:00', '0', NULL, NULL, 577, 1, 1, NULL, NULL, 0, 0),
(2055, '00:00', '00:00', '0', NULL, NULL, 577, 3, 1, NULL, NULL, 0, 0),
(2056, '00:00', '00:00', '0', NULL, NULL, 577, 4, 1, NULL, NULL, 0, 0),
(2057, '00:00', '00:00', '0', NULL, NULL, 577, 5, 1, NULL, NULL, 0, 0),
(2058, '00:00', '00:00', '0', NULL, NULL, 577, 7, 1, NULL, NULL, 0, 0),
(2059, '00:00', '00:00', '0', NULL, NULL, 577, 8, 1, NULL, NULL, 0, 0),
(2060, '00:00', '00:00', '0', NULL, NULL, 577, 10, 1, NULL, NULL, 0, 0),
(2061, '00:00', '00:00', '0', NULL, NULL, 578, 1, 1, NULL, NULL, 0, 0),
(2062, '00:00', '00:00', '0', NULL, NULL, 578, 2, 1, NULL, NULL, 0, 0),
(2063, '00:00', '00:00', '0', NULL, NULL, 578, 3, 1, NULL, NULL, 0, 0),
(2064, '00:00', '00:00', '0', NULL, NULL, 578, 4, 1, NULL, NULL, 0, 0),
(2065, '00:00', '00:00', '0', NULL, NULL, 578, 5, 1, NULL, NULL, 0, 0),
(2066, '00:00', '00:00', '0', NULL, NULL, 578, 7, 1, NULL, NULL, 0, 0),
(2067, '00:00', '00:00', '0', NULL, NULL, 578, 8, 1, NULL, NULL, 0, 0),
(2068, '00:00', '00:00', '0', NULL, NULL, 578, 10, 1, NULL, NULL, 0, 0),
(2069, '00:00', '00:00', '0', NULL, NULL, 579, 1, 1, NULL, NULL, 0, 0),
(2070, '00:00', '00:00', '0', NULL, NULL, 579, 2, 1, NULL, NULL, 0, 0),
(2071, '00:00', '00:00', '0', NULL, NULL, 579, 3, 1, NULL, NULL, 0, 0),
(2072, '00:00', '00:00', '0', NULL, NULL, 579, 4, 1, NULL, NULL, 0, 0),
(2073, '00:00', '00:00', '0', NULL, NULL, 579, 5, 1, NULL, NULL, 0, 0),
(2074, '00:00', '00:00', '0', NULL, NULL, 579, 7, 1, NULL, NULL, 0, 0),
(2075, '00:00', '00:00', '0', NULL, NULL, 579, 8, 1, NULL, NULL, 0, 0),
(2076, '00:00', '00:00', '0', NULL, NULL, 579, 10, 1, NULL, NULL, 0, 0),
(2077, '00:00', '00:00', '0', NULL, NULL, 580, 1, 1, NULL, NULL, 0, 0),
(2078, '00:00', '00:00', '0', NULL, NULL, 580, 3, 1, NULL, NULL, 0, 0),
(2079, '00:00', '00:00', '0', NULL, NULL, 580, 4, 1, NULL, NULL, 0, 0),
(2080, '00:00', '00:00', '0', NULL, NULL, 580, 5, 1, NULL, NULL, 0, 0),
(2081, '00:00', '00:00', '0', NULL, NULL, 580, 7, 1, NULL, NULL, 0, 0),
(2082, '00:00', '00:00', '0', NULL, NULL, 580, 8, 1, NULL, NULL, 0, 0),
(2083, '00:00', '00:00', '0', NULL, NULL, 580, 10, 1, NULL, NULL, 0, 0),
(2084, '00:00', '00:00', '0', NULL, NULL, 581, 1, 1, NULL, NULL, 0, 0),
(2085, '00:00', '00:00', '0', NULL, NULL, 581, 2, 1, NULL, NULL, 0, 0),
(2086, '00:00', '00:00', '0', NULL, NULL, 581, 3, 1, NULL, NULL, 0, 0),
(2087, '00:00', '00:00', '0', NULL, NULL, 581, 4, 1, NULL, NULL, 0, 0),
(2088, '00:00', '00:00', '0', NULL, NULL, 581, 5, 1, NULL, NULL, 0, 0),
(2089, '00:00', '00:00', '0', NULL, NULL, 581, 7, 1, NULL, NULL, 0, 0),
(2090, '00:00', '00:00', '0', NULL, NULL, 581, 8, 1, NULL, NULL, 0, 0),
(2091, '00:00', '00:00', '0', NULL, NULL, 581, 10, 1, NULL, NULL, 0, 0),
(2092, '00:00', '00:00', '0', NULL, NULL, 582, 1, 1, NULL, NULL, 0, 0),
(2093, '00:00', '00:00', '0', NULL, NULL, 582, 2, 1, NULL, NULL, 0, 0),
(2094, '00:00', '00:00', '0', NULL, NULL, 582, 3, 1, NULL, NULL, 0, 0),
(2095, '00:00', '00:00', '0', NULL, NULL, 582, 4, 1, NULL, NULL, 0, 0),
(2096, '00:00', '00:00', '0', NULL, NULL, 582, 5, 1, NULL, NULL, 0, 0),
(2097, '00:00', '00:00', '0', NULL, NULL, 582, 7, 1, NULL, NULL, 0, 0),
(2098, '00:00', '00:00', '0', NULL, NULL, 582, 8, 1, NULL, NULL, 0, 0),
(2099, '00:00', '00:00', '0', NULL, NULL, 582, 10, 1, NULL, NULL, 0, 0),
(2100, '00:00', '00:00', '0', NULL, NULL, 583, 1, 1, NULL, NULL, 0, 0),
(2101, '00:00', '00:00', '0', NULL, NULL, 583, 2, 1, NULL, NULL, 0, 0),
(2102, '00:00', '00:00', '0', NULL, NULL, 583, 3, 1, NULL, NULL, 0, 0),
(2103, '00:00', '00:00', '0', NULL, NULL, 583, 4, 1, NULL, NULL, 0, 0),
(2104, '00:00', '00:00', '0', NULL, NULL, 583, 5, 1, NULL, NULL, 0, 0),
(2105, '00:00', '00:00', '0', NULL, NULL, 583, 7, 1, NULL, NULL, 0, 0),
(2106, '00:00', '00:00', '0', NULL, NULL, 583, 8, 1, NULL, NULL, 0, 0),
(2107, '00:00', '00:00', '0', NULL, NULL, 583, 10, 1, NULL, NULL, 0, 0),
(2108, '00:00', '00:00', '0', NULL, NULL, 584, 1, 1, NULL, NULL, 0, 0),
(2109, '00:00', '00:00', '0', NULL, NULL, 584, 3, 1, NULL, NULL, 0, 0),
(2110, '00:00', '00:00', '0', NULL, NULL, 584, 4, 1, NULL, NULL, 0, 0),
(2111, '00:00', '00:00', '0', NULL, NULL, 584, 5, 1, NULL, NULL, 0, 0),
(2112, '00:00', '00:00', '0', NULL, NULL, 584, 7, 1, NULL, NULL, 0, 0),
(2113, '00:00', '00:00', '0', NULL, NULL, 584, 8, 1, NULL, NULL, 0, 0),
(2114, '00:00', '00:00', '0', NULL, NULL, 584, 10, 1, NULL, NULL, 0, 0),
(2115, '00:00', '00:00', '0', NULL, NULL, 585, 1, 1, NULL, NULL, 0, 0),
(2116, '00:00', '00:00', '0', NULL, NULL, 585, 2, 1, NULL, NULL, 0, 0),
(2117, '00:00', '00:00', '0', NULL, NULL, 585, 3, 1, NULL, NULL, 0, 0),
(2118, '00:00', '00:00', '0', NULL, NULL, 585, 4, 1, NULL, NULL, 0, 0),
(2119, '00:00', '00:00', '0', NULL, NULL, 585, 5, 1, NULL, NULL, 0, 0),
(2120, '00:00', '00:00', '0', NULL, NULL, 585, 7, 1, NULL, NULL, 0, 0),
(2121, '00:00', '00:00', '0', NULL, NULL, 585, 8, 1, NULL, NULL, 0, 0),
(2122, '00:00', '00:00', '0', NULL, NULL, 585, 10, 1, NULL, NULL, 0, 0),
(2123, '00:00', '00:00', '0', NULL, NULL, 586, 1, 1, NULL, NULL, 0, 0),
(2124, '00:00', '00:00', '0', NULL, NULL, 586, 2, 1, NULL, NULL, 0, 0),
(2125, '00:00', '00:00', '0', NULL, NULL, 586, 3, 1, NULL, NULL, 0, 0),
(2126, '00:00', '00:00', '0', NULL, NULL, 586, 4, 1, NULL, NULL, 0, 0),
(2127, '00:00', '00:00', '0', NULL, NULL, 586, 5, 1, NULL, NULL, 0, 0),
(2128, '00:00', '00:00', '0', NULL, NULL, 586, 7, 1, NULL, NULL, 0, 0),
(2129, '00:00', '00:00', '0', NULL, NULL, 586, 8, 1, NULL, NULL, 0, 0),
(2130, '00:00', '00:00', '0', NULL, NULL, 586, 10, 1, NULL, NULL, 0, 0),
(2131, '00:00', '00:00', '0', NULL, NULL, 587, 1, 1, NULL, NULL, 0, 0),
(2132, '00:00', '00:00', '0', NULL, NULL, 587, 3, 1, NULL, NULL, 0, 0),
(2133, '00:00', '00:00', '0', NULL, NULL, 587, 4, 1, NULL, NULL, 0, 0),
(2134, '00:00', '00:00', '0', NULL, NULL, 587, 5, 1, NULL, NULL, 0, 0),
(2135, '00:00', '00:00', '0', NULL, NULL, 587, 7, 1, NULL, NULL, 0, 0),
(2136, '00:00', '00:00', '0', NULL, NULL, 587, 8, 1, NULL, NULL, 0, 0),
(2137, '00:00', '00:00', '0', NULL, NULL, 587, 10, 1, NULL, NULL, 0, 0),
(2138, '00:00', '00:00', '0', NULL, NULL, 588, 1, 1, NULL, NULL, 0, 0),
(2139, '00:00', '00:00', '0', NULL, NULL, 588, 2, 1, NULL, NULL, 0, 0),
(2140, '00:00', '00:00', '0', NULL, NULL, 588, 3, 1, NULL, NULL, 0, 0),
(2141, '00:00', '00:00', '0', NULL, NULL, 588, 4, 1, NULL, NULL, 0, 0),
(2142, '00:00', '00:00', '0', NULL, NULL, 588, 5, 1, NULL, NULL, 0, 0),
(2143, '00:00', '00:00', '0', NULL, NULL, 588, 7, 1, NULL, NULL, 0, 0),
(2144, '00:00', '00:00', '0', NULL, NULL, 588, 8, 1, NULL, NULL, 0, 0),
(2145, '00:00', '00:00', '0', NULL, NULL, 588, 10, 1, NULL, NULL, 0, 0),
(2146, '00:00', '00:00', '0', NULL, NULL, 589, 1, 1, NULL, NULL, 0, 0),
(2147, '00:00', '00:00', '0', NULL, NULL, 589, 2, 1, NULL, NULL, 0, 0),
(2148, '00:00', '00:00', '0', NULL, NULL, 589, 3, 1, NULL, NULL, 0, 0),
(2149, '00:00', '00:00', '0', NULL, NULL, 589, 4, 1, NULL, NULL, 0, 0),
(2150, '00:00', '00:00', '0', NULL, NULL, 589, 5, 1, NULL, NULL, 0, 0),
(2151, '00:00', '00:00', '0', NULL, NULL, 589, 7, 1, NULL, NULL, 0, 0),
(2152, '00:00', '00:00', '0', NULL, NULL, 589, 8, 1, NULL, NULL, 0, 0),
(2153, '00:00', '00:00', '0', NULL, NULL, 589, 10, 1, NULL, NULL, 0, 0),
(2154, '00:00', '00:00', '0', NULL, NULL, 590, 1, 1, NULL, NULL, 0, 0),
(2155, '00:00', '00:00', '0', NULL, NULL, 590, 2, 1, NULL, NULL, 0, 0),
(2156, '00:00', '00:00', '0', NULL, NULL, 590, 3, 1, NULL, NULL, 0, 0),
(2157, '00:00', '00:00', '0', NULL, NULL, 590, 4, 1, NULL, NULL, 0, 0),
(2158, '00:00', '00:00', '0', NULL, NULL, 590, 5, 1, NULL, NULL, 0, 0),
(2159, '00:00', '00:00', '0', NULL, NULL, 590, 7, 1, NULL, NULL, 0, 0),
(2160, '00:00', '00:00', '0', NULL, NULL, 590, 8, 1, NULL, NULL, 0, 0),
(2161, '00:00', '00:00', '0', NULL, NULL, 590, 10, 1, NULL, NULL, 0, 0),
(2162, '00:00', '00:00', '0', NULL, NULL, 591, 1, 1, NULL, NULL, 0, 0),
(2163, '00:00', '00:00', '0', NULL, NULL, 591, 3, 1, NULL, NULL, 0, 0),
(2164, '00:00', '00:00', '0', NULL, NULL, 591, 4, 1, NULL, NULL, 0, 0),
(2165, '00:00', '00:00', '0', NULL, NULL, 591, 5, 1, NULL, NULL, 0, 0),
(2166, '00:00', '00:00', '0', NULL, NULL, 591, 7, 1, NULL, NULL, 0, 0),
(2167, '00:00', '00:00', '0', NULL, NULL, 591, 8, 1, NULL, NULL, 0, 0),
(2168, '00:00', '00:00', '0', NULL, NULL, 591, 10, 1, NULL, NULL, 0, 0),
(2169, '00:00', '00:00', '0', NULL, NULL, 592, 1, 1, NULL, NULL, 0, 0),
(2170, '00:00', '00:00', '0', NULL, NULL, 592, 2, 1, NULL, NULL, 0, 0),
(2171, '00:00', '00:00', '0', NULL, NULL, 592, 3, 1, NULL, NULL, 0, 0),
(2172, '00:00', '00:00', '0', NULL, NULL, 592, 4, 1, NULL, NULL, 0, 0),
(2173, '00:00', '00:00', '0', NULL, NULL, 592, 5, 1, NULL, NULL, 0, 0),
(2174, '00:00', '00:00', '0', NULL, NULL, 592, 7, 1, NULL, NULL, 0, 0),
(2175, '00:00', '00:00', '0', NULL, NULL, 592, 8, 1, NULL, NULL, 0, 0),
(2176, '00:00', '00:00', '0', NULL, NULL, 592, 10, 1, NULL, NULL, 0, 0),
(2177, '00:00', '00:00', '0', NULL, NULL, 593, 1, 1, NULL, NULL, 0, 0),
(2178, '00:00', '00:00', '0', NULL, NULL, 593, 3, 1, NULL, NULL, 0, 0),
(2179, '00:00', '00:00', '0', NULL, NULL, 593, 4, 1, NULL, NULL, 0, 0),
(2180, '00:00', '00:00', '0', NULL, NULL, 593, 5, 1, NULL, NULL, 0, 0),
(2181, '00:00', '00:00', '0', NULL, NULL, 593, 7, 1, NULL, NULL, 0, 0),
(2182, '00:00', '00:00', '0', NULL, NULL, 593, 8, 1, NULL, NULL, 0, 0),
(2183, '00:00', '00:00', '0', NULL, NULL, 593, 10, 1, NULL, NULL, 0, 0),
(2184, '00:00', '00:00', '0', NULL, NULL, 594, 1, 1, NULL, NULL, 0, 0),
(2185, '00:00', '00:00', '0', NULL, NULL, 594, 2, 1, NULL, NULL, 0, 0),
(2186, '00:00', '00:00', '0', NULL, NULL, 594, 3, 1, NULL, NULL, 0, 0),
(2187, '00:00', '00:00', '0', NULL, NULL, 594, 4, 1, NULL, NULL, 0, 0),
(2188, '00:00', '00:00', '0', NULL, NULL, 594, 5, 1, NULL, NULL, 0, 0),
(2189, '00:00', '00:00', '0', NULL, NULL, 594, 7, 1, NULL, NULL, 0, 0),
(2190, '00:00', '00:00', '0', NULL, NULL, 594, 8, 1, NULL, NULL, 0, 0),
(2191, '00:00', '00:00', '0', NULL, NULL, 594, 10, 1, NULL, NULL, 0, 0),
(2192, '00:00', '00:00', '0', NULL, NULL, 595, 1, 1, NULL, NULL, 0, 0),
(2193, '00:00', '00:00', '0', NULL, NULL, 595, 2, 1, NULL, NULL, 0, 0),
(2194, '00:00', '00:00', '0', NULL, NULL, 595, 3, 1, NULL, NULL, 0, 0),
(2195, '00:00', '00:00', '0', NULL, NULL, 595, 4, 1, NULL, NULL, 0, 0),
(2196, '00:00', '00:00', '0', NULL, NULL, 595, 5, 1, NULL, NULL, 0, 0),
(2197, '00:00', '00:00', '0', NULL, NULL, 595, 7, 1, NULL, NULL, 0, 0),
(2198, '00:00', '00:00', '0', NULL, NULL, 595, 8, 1, NULL, NULL, 0, 0),
(2199, '00:00', '00:00', '0', NULL, NULL, 595, 10, 1, NULL, NULL, 0, 0),
(2200, '00:00', '00:00', '0', NULL, NULL, 596, 1, 1, NULL, NULL, 0, 0),
(2201, '00:00', '00:00', '0', NULL, NULL, 596, 3, 1, NULL, NULL, 0, 0),
(2202, '00:00', '00:00', '0', NULL, NULL, 596, 4, 1, NULL, NULL, 0, 0),
(2203, '00:00', '00:00', '0', NULL, NULL, 596, 5, 1, NULL, NULL, 0, 0),
(2204, '00:00', '00:00', '0', NULL, NULL, 596, 7, 1, NULL, NULL, 0, 0),
(2205, '00:00', '00:00', '0', NULL, NULL, 596, 8, 1, NULL, NULL, 0, 0),
(2206, '00:00', '00:00', '0', NULL, NULL, 596, 10, 1, NULL, NULL, 0, 0),
(2207, '00:00', '00:00', '0', NULL, NULL, 597, 1, 1, NULL, NULL, 0, 0),
(2208, '00:00', '00:00', '0', NULL, NULL, 597, 2, 1, NULL, NULL, 0, 0),
(2209, '00:00', '00:00', '0', NULL, NULL, 597, 3, 1, NULL, NULL, 0, 0),
(2210, '00:00', '00:00', '0', NULL, NULL, 597, 4, 1, NULL, NULL, 0, 0),
(2211, '00:00', '00:00', '0', NULL, NULL, 597, 5, 1, NULL, NULL, 0, 0),
(2212, '00:00', '00:00', '0', NULL, NULL, 597, 7, 1, NULL, NULL, 0, 0),
(2213, '00:00', '00:00', '0', NULL, NULL, 597, 8, 1, NULL, NULL, 0, 0),
(2214, '00:00', '00:00', '0', NULL, NULL, 597, 10, 1, NULL, NULL, 0, 0),
(2215, '00:00', '00:00', '0', NULL, NULL, 598, 1, 1, NULL, NULL, 0, 0),
(2216, '00:00', '00:00', '0', NULL, NULL, 598, 2, 1, NULL, NULL, 0, 0),
(2217, '00:00', '00:00', '0', NULL, NULL, 598, 3, 1, NULL, NULL, 0, 0),
(2218, '00:00', '00:00', '0', NULL, NULL, 598, 4, 1, NULL, NULL, 0, 0),
(2219, '00:00', '00:00', '0', NULL, NULL, 598, 5, 1, NULL, NULL, 0, 0),
(2220, '00:00', '00:00', '0', NULL, NULL, 598, 7, 1, NULL, NULL, 0, 0),
(2221, '00:00', '00:00', '0', NULL, NULL, 598, 8, 1, NULL, NULL, 0, 0),
(2222, '00:00', '00:00', '0', NULL, NULL, 598, 10, 1, NULL, NULL, 0, 0),
(2223, '00:00', '00:00', '0', NULL, NULL, 599, 1, 1, NULL, NULL, 0, 0),
(2224, '00:00', '00:00', '0', NULL, NULL, 599, 3, 1, NULL, NULL, 0, 0),
(2225, '00:00', '00:00', '0', NULL, NULL, 599, 4, 1, NULL, NULL, 0, 0),
(2226, '00:00', '00:00', '0', NULL, NULL, 599, 5, 1, NULL, NULL, 0, 0),
(2227, '00:00', '00:00', '0', NULL, NULL, 599, 7, 1, NULL, NULL, 0, 0),
(2228, '00:00', '00:00', '0', NULL, NULL, 599, 8, 1, NULL, NULL, 0, 0),
(2229, '00:00', '00:00', '0', NULL, NULL, 599, 10, 1, NULL, NULL, 0, 0),
(2230, '00:00', '00:00', '0', NULL, NULL, 600, 1, 1, NULL, NULL, 0, 0),
(2231, '00:00', '00:00', '0', NULL, NULL, 600, 3, 1, NULL, NULL, 0, 0),
(2232, '00:00', '00:00', '0', NULL, NULL, 600, 4, 1, NULL, NULL, 0, 0),
(2233, '00:00', '00:00', '0', NULL, NULL, 600, 5, 1, NULL, NULL, 0, 0),
(2234, '00:00', '00:00', '0', NULL, NULL, 600, 7, 1, NULL, NULL, 0, 0),
(2235, '00:00', '00:00', '0', NULL, NULL, 600, 8, 1, NULL, NULL, 0, 0),
(2236, '00:00', '00:00', '0', NULL, NULL, 600, 10, 1, NULL, NULL, 0, 0),
(2237, '00:00', '00:00', '0', NULL, NULL, 601, 1, 1, NULL, NULL, 0, 0),
(2238, '00:00', '00:00', '0', NULL, NULL, 601, 2, 1, NULL, NULL, 0, 0),
(2239, '00:00', '00:00', '0', NULL, NULL, 601, 3, 1, NULL, NULL, 0, 0),
(2240, '00:00', '00:00', '0', NULL, NULL, 601, 4, 1, NULL, NULL, 0, 0),
(2241, '00:00', '00:00', '0', NULL, NULL, 601, 5, 1, NULL, NULL, 0, 0),
(2242, '00:00', '00:00', '0', NULL, NULL, 601, 6, 1, NULL, NULL, 0, 0),
(2243, '00:00', '00:00', '0', NULL, NULL, 601, 7, 1, NULL, NULL, 0, 0),
(2244, '00:00', '00:00', '0', NULL, NULL, 601, 8, 1, NULL, NULL, 0, 0),
(2245, '00:00', '00:00', '0', NULL, NULL, 601, 9, 1, NULL, NULL, 0, 0),
(2246, '00:00', '00:00', '0', NULL, NULL, 601, 10, 1, NULL, NULL, 0, 0),
(2247, '00:00', '00:00', '0', NULL, NULL, 602, 1, 1, NULL, NULL, 0, 0),
(2248, '00:00', '00:00', '0', NULL, NULL, 602, 3, 1, NULL, NULL, 0, 0),
(2249, '00:00', '00:00', '0', NULL, NULL, 602, 4, 1, NULL, NULL, 0, 0),
(2250, '00:00', '00:00', '0', NULL, NULL, 602, 5, 1, NULL, NULL, 0, 0),
(2251, '00:00', '00:00', '0', NULL, NULL, 602, 6, 1, NULL, NULL, 0, 0),
(2252, '00:00', '00:00', '0', NULL, NULL, 602, 7, 1, NULL, NULL, 0, 0),
(2253, '00:00', '00:00', '0', NULL, NULL, 602, 8, 1, NULL, NULL, 0, 0),
(2254, '00:00', '00:00', '0', NULL, NULL, 602, 9, 1, NULL, NULL, 0, 0),
(2255, '00:00', '00:00', '0', NULL, NULL, 602, 10, 1, NULL, NULL, 0, 0),
(2256, '00:00', '00:00', '0', NULL, NULL, 603, 1, 1, NULL, NULL, 0, 0),
(2257, '00:00', '00:00', '0', NULL, NULL, 603, 2, 1, NULL, NULL, 0, 0),
(2258, '00:00', '00:00', '0', NULL, NULL, 603, 3, 1, NULL, NULL, 0, 0),
(2259, '00:00', '00:00', '0', NULL, NULL, 603, 4, 1, NULL, NULL, 0, 0),
(2260, '00:00', '00:00', '0', NULL, NULL, 603, 5, 1, NULL, NULL, 0, 0),
(2261, '00:00', '00:00', '0', NULL, NULL, 603, 7, 1, NULL, NULL, 0, 0),
(2262, '00:00', '00:00', '0', NULL, NULL, 603, 8, 1, NULL, NULL, 0, 0),
(2263, '00:00', '00:00', '0', NULL, NULL, 603, 10, 1, NULL, NULL, 0, 0),
(2264, '00:00', '00:00', '0', NULL, NULL, 604, 1, 1, NULL, NULL, 0, 0),
(2265, '00:00', '00:00', '0', NULL, NULL, 604, 2, 1, NULL, NULL, 0, 0),
(2266, '00:00', '00:00', '0', NULL, NULL, 604, 3, 1, NULL, NULL, 0, 0),
(2267, '00:00', '00:00', '0', NULL, NULL, 604, 4, 1, NULL, NULL, 0, 0),
(2268, '00:00', '00:00', '0', NULL, NULL, 604, 5, 1, NULL, NULL, 0, 0),
(2269, '00:00', '00:00', '0', NULL, NULL, 604, 7, 1, NULL, NULL, 0, 0),
(2270, '00:00', '00:00', '0', NULL, NULL, 604, 8, 1, NULL, NULL, 0, 0),
(2271, '00:00', '00:00', '0', NULL, NULL, 604, 10, 1, NULL, NULL, 0, 0),
(2272, '00:00', '00:00', '0', NULL, NULL, 605, 1, 1, NULL, NULL, 0, 0),
(2273, '00:00', '00:00', '0', NULL, NULL, 605, 2, 1, NULL, NULL, 0, 0),
(2274, '00:00', '00:00', '0', NULL, NULL, 605, 3, 1, NULL, NULL, 0, 0),
(2275, '00:00', '00:00', '0', NULL, NULL, 605, 4, 1, NULL, NULL, 0, 0),
(2276, '00:00', '00:00', '0', NULL, NULL, 605, 5, 1, NULL, NULL, 0, 0),
(2277, '00:00', '00:00', '0', NULL, NULL, 605, 6, 1, NULL, NULL, 0, 0),
(2278, '00:00', '00:00', '0', NULL, NULL, 605, 7, 1, NULL, NULL, 0, 0),
(2279, '00:00', '00:00', '0', NULL, NULL, 605, 8, 1, NULL, NULL, 0, 0),
(2280, '00:00', '00:00', '0', NULL, NULL, 605, 9, 1, NULL, NULL, 0, 0),
(2281, '00:00', '00:00', '0', NULL, NULL, 605, 10, 1, NULL, NULL, 0, 0),
(2282, '00:00', '00:00', '0', NULL, NULL, 606, 1, 1, NULL, NULL, 0, 0),
(2283, '00:00', '00:00', '0', NULL, NULL, 606, 2, 1, NULL, NULL, 0, 0),
(2284, '00:00', '00:00', '0', NULL, NULL, 606, 3, 1, NULL, NULL, 0, 0),
(2285, '00:00', '00:00', '0', NULL, NULL, 606, 4, 1, NULL, NULL, 0, 0),
(2286, '00:00', '00:00', '0', NULL, NULL, 606, 5, 1, NULL, NULL, 0, 0),
(2287, '00:00', '00:00', '0', NULL, NULL, 606, 6, 1, NULL, NULL, 0, 0),
(2288, '00:00', '00:00', '0', NULL, NULL, 606, 7, 1, NULL, NULL, 0, 0),
(2289, '00:00', '00:00', '0', NULL, NULL, 606, 8, 1, NULL, NULL, 0, 0),
(2290, '00:00', '00:00', '0', NULL, NULL, 606, 10, 1, NULL, NULL, 0, 0),
(2291, '00:00', '00:00', '0', NULL, NULL, 607, 1, 1, NULL, NULL, 0, 0),
(2292, '00:00', '00:00', '0', NULL, NULL, 607, 3, 1, NULL, NULL, 0, 0),
(2293, '00:00', '00:00', '0', NULL, NULL, 607, 4, 1, NULL, NULL, 0, 0),
(2294, '00:00', '00:00', '0', NULL, NULL, 607, 5, 1, NULL, NULL, 0, 0),
(2295, '00:00', '00:00', '0', NULL, NULL, 607, 6, 1, NULL, NULL, 0, 0),
(2296, '00:00', '00:00', '0', NULL, NULL, 607, 7, 1, NULL, NULL, 0, 0),
(2297, '00:00', '00:00', '0', NULL, NULL, 607, 8, 1, NULL, NULL, 0, 0),
(2298, '00:00', '00:00', '0', NULL, NULL, 607, 9, 1, NULL, NULL, 0, 0),
(2299, '00:00', '00:00', '0', NULL, NULL, 607, 10, 1, NULL, NULL, 0, 0),
(2300, '00:00', '00:00', '0', NULL, NULL, 608, 1, 1, NULL, NULL, 0, 0),
(2301, '00:00', '00:00', '0', NULL, NULL, 608, 2, 1, NULL, NULL, 0, 0),
(2302, '00:00', '00:00', '0', NULL, NULL, 608, 3, 1, NULL, NULL, 0, 0),
(2303, '00:00', '00:00', '0', NULL, NULL, 608, 4, 1, NULL, NULL, 0, 0),
(2304, '00:00', '00:00', '0', NULL, NULL, 608, 5, 1, NULL, NULL, 0, 0),
(2305, '00:00', '00:00', '0', NULL, NULL, 608, 7, 1, NULL, NULL, 0, 0),
(2306, '00:00', '00:00', '0', NULL, NULL, 608, 8, 1, NULL, NULL, 0, 0),
(2307, '00:00', '00:00', '0', NULL, NULL, 608, 10, 1, NULL, NULL, 0, 0),
(2308, '00:00', '00:00', '0', NULL, NULL, 609, 1, 1, NULL, NULL, 0, 0),
(2309, '00:00', '00:00', '0', NULL, NULL, 609, 2, 1, NULL, NULL, 0, 0),
(2310, '00:00', '00:00', '0', NULL, NULL, 609, 3, 1, NULL, NULL, 0, 0),
(2311, '00:00', '00:00', '0', NULL, NULL, 609, 4, 1, NULL, NULL, 0, 0),
(2312, '00:00', '00:00', '0', NULL, NULL, 609, 5, 1, NULL, NULL, 0, 0),
(2313, '00:00', '00:00', '0', NULL, NULL, 609, 6, 1, NULL, NULL, 0, 0),
(2314, '00:00', '00:00', '0', NULL, NULL, 609, 7, 1, NULL, NULL, 0, 0),
(2315, '00:00', '00:00', '0', NULL, NULL, 609, 8, 1, NULL, NULL, 0, 0),
(2316, '00:00', '00:00', '0', NULL, NULL, 609, 9, 1, NULL, NULL, 0, 0),
(2317, '00:00', '00:00', '0', NULL, NULL, 609, 10, 1, NULL, NULL, 0, 0),
(2318, '00:00', '00:00', '0', NULL, NULL, 610, 1, 1, NULL, NULL, 0, 0),
(2319, '00:00', '00:00', '0', NULL, NULL, 610, 2, 1, NULL, NULL, 0, 0),
(2320, '00:00', '00:00', '0', NULL, NULL, 610, 3, 1, NULL, NULL, 0, 0),
(2321, '00:00', '00:00', '0', NULL, NULL, 610, 4, 1, NULL, NULL, 0, 0),
(2322, '00:00', '00:00', '0', NULL, NULL, 610, 5, 1, NULL, NULL, 0, 0),
(2323, '00:00', '00:00', '0', NULL, NULL, 610, 7, 1, NULL, NULL, 0, 0),
(2324, '00:00', '00:00', '0', NULL, NULL, 610, 8, 1, NULL, NULL, 0, 0),
(2325, '00:00', '00:00', '0', NULL, NULL, 610, 10, 1, NULL, NULL, 0, 0),
(2326, '00:00', '00:00', '0', NULL, NULL, 611, 1, 1, NULL, NULL, 0, 0),
(2327, '00:00', '00:00', '0', NULL, NULL, 611, 2, 1, NULL, NULL, 0, 0),
(2328, '00:00', '00:00', '0', NULL, NULL, 611, 3, 1, NULL, NULL, 0, 0),
(2329, '00:00', '00:00', '0', NULL, NULL, 611, 4, 1, NULL, NULL, 0, 0),
(2330, '00:00', '00:00', '0', NULL, NULL, 611, 5, 1, NULL, NULL, 0, 0),
(2331, '00:00', '00:00', '0', NULL, NULL, 611, 7, 1, NULL, NULL, 0, 0),
(2332, '00:00', '00:00', '0', NULL, NULL, 611, 8, 1, NULL, NULL, 0, 0),
(2333, '00:00', '00:00', '0', NULL, NULL, 611, 10, 1, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_proyecto`
--

CREATE TABLE `detalle_proyecto` (
  `idDetalle_proyecto` int(11) NOT NULL,
  `tipo_negocio_idtipo_negocio` tinyint(4) NOT NULL,
  `canitadad_total` varchar(6) NOT NULL,
  `material` varchar(6) DEFAULT NULL,
  `proyecto_numero_orden` int(11) NOT NULL,
  `negocio_idnegocio` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL,
  `PNC` tinyint(1) NOT NULL,
  `ubicacion` varchar(25) DEFAULT NULL,
  `pro_porIniciar` tinyint(10) DEFAULT '0',
  `pro_Ejecucion` tinyint(10) DEFAULT '0',
  `pro_Pausado` tinyint(10) DEFAULT '0',
  `pro_Terminado` tinyint(10) DEFAULT '0',
  `tiempo_total` varchar(20) DEFAULT NULL,
  `Total_timepo_Unidad` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_proyecto`
--

INSERT INTO `detalle_proyecto` (`idDetalle_proyecto`, `tipo_negocio_idtipo_negocio`, `canitadad_total`, `material`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`, `PNC`, `ubicacion`, `pro_porIniciar`, `pro_Ejecucion`, `pro_Pausado`, `pro_Terminado`, `tiempo_total`, `Total_timepo_Unidad`) VALUES
(458, 1, '25', 'TH', 29359, 1, 2, 0, NULL, 1, 0, 1, 8, '980:55', NULL),
(533, 1, '10', 'TH', 29366, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(534, 1, '10', 'TH', 29367, 1, 1, 0, NULL, 10, 0, 0, 0, '00:00', NULL),
(535, 1, '10', 'TH', 29368, 1, 1, 0, NULL, 8, 0, 0, 0, '00:00', NULL),
(545, 7, '10', 'TH', 29365, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(546, 11, '', NULL, 29365, 4, 3, 0, NULL, 0, 0, 0, 1, '0', NULL),
(547, 8, '12', 'GF', 29369, 4, 3, 0, NULL, 0, 0, 0, 1, '0', NULL),
(548, 10, '', NULL, 29370, 4, 3, 0, NULL, 0, 0, 0, 1, '1', NULL),
(549, 11, '', NULL, 29370, 4, 3, 0, NULL, 0, 0, 0, 1, '1', NULL),
(550, 2, '1', 'FV', 29370, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(551, 4, '2', 'FV', 29370, 1, 1, 0, NULL, 2, 0, 0, 0, NULL, NULL),
(552, 3, '3', 'FV', 29370, 1, 1, 0, NULL, 2, 0, 0, 0, NULL, NULL),
(553, 6, '4', '', 29370, 1, 1, 0, NULL, 1, 0, 0, 0, NULL, NULL),
(556, 5, '7', '', 29370, 2, 1, 0, NULL, 4, 0, 0, 0, NULL, NULL),
(557, 1, '8', '', 29370, 3, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(560, 7, '6', 'TH', 29370, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(561, 1, '5', 'TH', 29370, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(562, 1, '10', 'FV', 29371, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(563, 1, '2', 'TH', 29372, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(564, 1, '3', 'FV', 29373, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(565, 1, '4', 'TH', 29374, 1, 1, 0, NULL, 9, 0, 0, 0, NULL, NULL),
(566, 1, '6', 'TH', 29375, 1, 1, 0, NULL, 9, 0, 0, 0, NULL, NULL),
(567, 1, '7', 'FV', 29376, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(568, 1, '7', 'TH', 29377, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(569, 1, '8', 'FV', 29378, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(570, 1, '9', 'FV', 29379, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(571, 1, '10', 'TH', 29380, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(572, 1, '20', 'TH', 29381, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(573, 1, '12', 'FV', 29382, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(574, 1, '13', 'TH', 29383, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(575, 1, '14', 'TH', 29384, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(576, 1, '15', 'TH', 29385, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(577, 1, '16', 'FV', 29386, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(578, 1, '17', 'TH', 29387, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(579, 1, '18', 'TH', 29388, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(580, 1, '19', 'FV', 29389, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(581, 1, '20', 'TH', 29390, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(582, 1, '21', 'TH', 29391, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(583, 1, '22', 'TH', 29392, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(584, 1, '23', 'FV', 29393, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(585, 1, '24', 'TH', 29394, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(586, 1, '24', 'TH', 29395, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(587, 1, '26', 'FV', 29396, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(588, 1, '27', 'TH', 29397, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(589, 1, '28', 'TH', 29398, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(590, 1, '29', 'TH', 29399, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(591, 1, '30', 'FV', 29400, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(592, 1, '31', 'TH', 29401, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(593, 1, '32', 'FV', 29402, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(594, 1, '33', 'TH', 29403, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(595, 1, '34', 'TH', 29404, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(596, 1, '35', 'FV', 29405, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(597, 1, '36', 'TH', 29406, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(598, 1, '37', 'TH', 29407, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(599, 1, '38', 'FV', 29408, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(600, 1, '39', 'FV', 29409, 1, 1, 0, NULL, 7, 0, 0, 0, NULL, NULL),
(601, 1, '40', 'TH', 29410, 1, 1, 0, NULL, 10, 0, 0, 0, NULL, NULL),
(602, 1, '41', 'FV', 29411, 1, 1, 0, NULL, 9, 0, 0, 0, NULL, NULL),
(603, 1, '42', 'TH', 29412, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(604, 1, '43', 'TH', 29413, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(605, 1, '44', 'TH', 29414, 1, 1, 0, NULL, 10, 0, 0, 0, NULL, NULL),
(606, 1, '45', 'TH', 29415, 1, 1, 0, NULL, 9, 0, 0, 0, NULL, NULL),
(607, 1, '46', 'FV', 29416, 1, 1, 0, NULL, 9, 0, 0, 0, NULL, NULL),
(608, 1, '47', 'TH', 29417, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(609, 1, '48', 'TH', 29418, 1, 1, 0, NULL, 10, 0, 0, 0, NULL, NULL),
(610, 1, '49', 'TH', 29419, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL),
(611, 1, '50', 'TH', 29420, 1, 1, 0, NULL, 8, 0, 0, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_teclados`
--

CREATE TABLE `detalle_teclados` (
  `idDetalle_teclados` smallint(6) NOT NULL,
  `tiempo_por_unidad` varchar(6) DEFAULT NULL,
  `tiempo_total_proceso` varchar(10) DEFAULT NULL,
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL,
  `hora_ejecucion` time DEFAULT NULL,
  `hora_terminacion` time DEFAULT NULL,
  `restantes` int(6) NOT NULL DEFAULT '0',
  `noperarios` tinyint(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_teclados`
--

INSERT INTO `detalle_teclados` (`idDetalle_teclados`, `tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`, `hora_ejecucion`, `hora_terminacion`, `restantes`, `noperarios`) VALUES
(1, '00:00', '00:00', '0', NULL, NULL, 556, 11, 1, NULL, NULL, 0, 0),
(2, '00:00', '00:00', '0', NULL, NULL, 556, 12, 1, NULL, NULL, 0, 0),
(3, '00:00', '00:00', '0', NULL, NULL, 556, 13, 1, NULL, NULL, 0, 0),
(4, '00:00', '00:00', '0', NULL, NULL, 556, 14, 1, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `idestado` tinyint(4) NOT NULL,
  `nombre` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`idestado`, `nombre`) VALUES
(4, 'Ejecucion'),
(2, 'Pausado'),
(1, 'Por iniciar'),
(3, 'Terminado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `negocio`
--

CREATE TABLE `negocio` (
  `idnegocio` tinyint(4) NOT NULL,
  `nom_negocio` varchar(7) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `negocio`
--

INSERT INTO `negocio` (`idnegocio`, `nom_negocio`, `estado`) VALUES
(1, 'FE', 1),
(2, 'TE', 1),
(3, 'IN', 1),
(4, 'ALMACEN', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesos`
--

CREATE TABLE `procesos` (
  `idproceso` tinyint(4) NOT NULL,
  `nombre_proceso` varchar(25) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `negocio_idnegocio` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `procesos`
--

INSERT INTO `procesos` (`idproceso`, `nombre_proceso`, `estado`, `negocio_idnegocio`) VALUES
(1, 'Perforado', 1, 1),
(2, 'Quimicos', 1, 1),
(3, 'Caminos', 1, 1),
(4, 'Quemado', 1, 1),
(5, 'C.C.TH', 1, 1),
(6, 'Screen', 1, 1),
(7, 'Estañado', 1, 1),
(8, 'C.C.2', 1, 1),
(9, 'Ruteo', 1, 1),
(10, 'Maquinas', 1, 1),
(11, 'Correas y Conversor', 1, 2),
(12, 'Lexan', 1, 2),
(13, 'Acople', 1, 2),
(14, 'Control calidad', 1, 2),
(15, 'Manual', 1, 3),
(16, 'Limpieza', 1, 3),
(17, 'Control Calidad', 1, 3),
(18, 'Empaque', 1, 3),
(19, 'Stencil', 1, 3),
(20, 'Linea', 1, 3),
(21, 'Arnes', 1, 3),
(22, 'GF', 1, 1),
(23, 'Componentes', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `numero_orden` int(11) NOT NULL,
  `usuario_numero_documento` varchar(13) NOT NULL,
  `nombre_cliente` varchar(150) DEFAULT NULL,
  `nombre_proyecto` varchar(150) DEFAULT NULL,
  `tipo_proyecto` varchar(6) DEFAULT NULL,
  `FE` tinyint(1) NOT NULL,
  `TE` tinyint(1) NOT NULL,
  `IN` tinyint(1) NOT NULL,
  `pcb_FE` tinyint(1) NOT NULL,
  `pcb_TE` tinyint(1) NOT NULL,
  `Conversor` tinyint(1) NOT NULL,
  `Repujado` tinyint(1) NOT NULL,
  `troquel` tinyint(1) NOT NULL,
  `stencil` tinyint(1) NOT NULL,
  `lexan` tinyint(1) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `fecha_salidal` datetime DEFAULT NULL,
  `ruteoC` tinyint(1) DEFAULT NULL,
  `antisolderC` tinyint(1) DEFAULT NULL,
  `estado_idestado` tinyint(4) NOT NULL,
  `antisolderP` tinyint(1) DEFAULT NULL,
  `ruteoP` tinyint(1) DEFAULT NULL,
  `eliminacion` tinyint(1) DEFAULT '1',
  `parada` tinyint(1) DEFAULT '1',
  `entregaCircuitoFEoGF` date DEFAULT NULL,
  `entregaCOMCircuito` date DEFAULT NULL,
  `entregaPCBFEoGF` date DEFAULT NULL,
  `entregaPCBCom` date DEFAULT NULL,
  `novedades` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`numero_orden`, `usuario_numero_documento`, `nombre_cliente`, `nombre_proyecto`, `tipo_proyecto`, `FE`, `TE`, `IN`, `pcb_FE`, `pcb_TE`, `Conversor`, `Repujado`, `troquel`, `stencil`, `lexan`, `fecha_ingreso`, `fecha_entrega`, `fecha_salidal`, `ruteoC`, `antisolderC`, `estado_idestado`, `antisolderP`, `ruteoP`, `eliminacion`, `parada`, `entregaCircuitoFEoGF`, `entregaCOMCircuito`, `entregaPCBFEoGF`, `entregaPCBCom`, `novedades`) VALUES
(29359, '3004991084', 'Micro Hom SAS Cali', 'Control Planta', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-15 08:34:13', '2018-01-15', NULL, 1, 1, 2, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29365, '981130', 'juan david marulanda paniagua', 'prueba de eliminacion numero 1', 'Normal', 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, '2018-01-17 09:20:36', '2018-01-18', NULL, 0, 0, 2, 0, 0, 1, 1, NULL, NULL, '2018-01-18', '2018-01-20', NULL),
(29366, '981130', 'juan david marulanda', 'prueba de eliminacion numero 2', 'Normal', 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, '2018-01-17 10:56:49', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29367, '981130', 'juan david marulanda', 'prueba', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-18 15:42:35', '2018-01-18', NULL, 1, 1, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-18', '2018-01-20', NULL),
(29368, '981130', 'juan david marulanda', 'prueba numero 2', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-18 15:55:36', '2018-01-17', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-18', '2018-01-20', NULL),
(29369, '981130', ' juan david marulanda paniagua', 'prueba de registro solo almacen', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 09:07:33', '2018-01-23', '2018-01-22 09:08:47', 0, 0, 3, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29370, '981130', 'juan david marulanda', 'registro de todo los proyecto y modificacione', 'Normal', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, '2018-01-22 09:27:10', '2018-01-23', NULL, 0, 0, 2, 0, 0, 1, 1, '2018-01-20', '2018-01-23', '2018-01-24', '2018-01-25', NULL),
(29371, '981130', 'juan david marulanda paniagua', 'proyecto numero 1', 'RQT', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 09:59:24', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-24', '2018-01-25', NULL),
(29372, '981130', 'juan david marulanda paniagua', 'proyecto numero 2', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:00:04', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-24', '2018-01-25', NULL),
(29373, '981130', 'juan david marulanda paniagua', 'proyecto numero 3', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:02:04', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-24', '2018-01-25', NULL),
(29374, '981130', 'juan david marulanda paniagua ', 'proyecto nuemro 4', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:02:48', '2018-01-23', NULL, 0, 1, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29375, '981130', 'juan david marulanda paniagua ', 'proyecto numero 5', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:03:23', '2018-01-23', NULL, 1, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29376, '981130', 'juand david marulanda panigua', 'proyecto numero 6', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:04:06', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-24', '2018-01-25', NULL),
(29377, '981130', 'juan david marulanda panigua', 'proyecto numero 7', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:04:54', '2018-01-22', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-24', '2018-01-25', NULL),
(29378, '981130', 'fredy ', 'proyecto numero 8', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:08:04', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29379, '981130', 'fernando', 'proyecto numero 9', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:08:53', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29380, '981130', 'nicolas blandon', 'proyecto numero 10', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:11:10', '2018-01-24', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29381, '981130', 'fabian guillermo', 'proyecto numero 11', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:12:54', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-18', '2018-01-20', NULL),
(29382, '981130', 'francisco venedicto bergoglio', 'proyecto numero 12', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:15:19', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-18', '2018-01-20', NULL),
(29383, '981130', 'juan andres piedraita', 'proyecto numero 13', 'RQT', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:15:53', '2018-01-24', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-18', '2018-01-20', NULL),
(29384, '981130', 'juan david marulanda panigua', 'proyecto numero 14', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:18:57', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, '2018-01-18', '2018-01-20', NULL),
(29385, '981130', 'juan david marulanda', 'proyecto numero 15', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:59:10', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 0, NULL, NULL, NULL, NULL, NULL),
(29386, '981130', 'juan camilo', 'proyecto numero 16', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:59:35', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29387, '981130', 'juan david castaño', 'proyecto numero 17', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 10:59:59', '2018-01-25', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29388, '981130', 'juan camilo', 'proyecto numero 18', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:02:42', '2018-01-24', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29389, '981130', 'juan david marulada', 'proyecto numero 19', 'RQT', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:03:11', '2018-01-25', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29390, '981130', 'juan camilo muñoz', 'proyecto numero 20', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:04:34', '2018-01-25', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29391, '981130', 'juan david marulanda ', 'proyecto numero 21', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:09:41', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29392, '981130', 'juan david marulanda paniagua', 'proyecto numero 22', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:10:08', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29393, '981130', 'juan andres gutierres', 'proyecto numero 23', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:10:39', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29394, '981130', 'jorge bolaños', 'proyecto numero 24', 'RQT', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:11:30', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29395, '981130', 'juan david marulanda paniagua', 'proyecto nuemero 25', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:12:57', '2018-01-24', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29396, '981130', 'juan camilo bolaños', 'proyecto numero 26', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:15:23', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29397, '981130', 'juan camilo muñoz', 'proyecto numero 27', 'RQT', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:15:56', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29398, '981130', 'juan david marulanda', 'proyecto numero 28', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:16:21', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29399, '981130', 'juan david marulanda ', 'proyecto numero 29', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:17:19', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29400, '981130', 'andres castaño ortiz', 'proyecto numero 30', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:18:30', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29401, '981130', 'juan david marulanda p', 'proyecto numero 31', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:26:26', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29402, '981130', 'juan david marulanda p', 'proyecto numero 32', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:27:44', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29403, '981130', 'cristian camilo', 'proyecto numero 33', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:28:22', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29404, '981130', 'juan esteban pulgarin', 'proyecto numero 34', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:29:11', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29405, '981130', 'juan esteban pulgarin', 'proyecto numero 35', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:30:18', '2018-01-26', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29406, '981130', 'juan david marulanda p', 'proyecto numero 36', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:30:53', '2018-01-26', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29407, '981130', 'juan cristian camilo p', 'proyecto numero 37', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:31:37', '2018-01-24', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29408, '981130', 'juan david marulanda b', 'proyecto numero 38', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:34:00', '2018-01-24', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29409, '981130', 'juan camilo marulanda', 'proyecto numero 39', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:36:27', '2018-01-24', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29410, '981130', 'juan camilo lopera', 'proyecto numero 40', 'RQT', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:36:59', '2018-01-23', NULL, 1, 1, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29411, '981130', 'ultimo proyecto ', 'proyecto numero 41', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:38:16', '2018-01-23', NULL, 1, 1, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29412, '981130', 'juan david marulanda', 'proyecto numero 42', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:40:05', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29413, '981130', 'juan david marulanda', 'proyecto numero 43', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:40:39', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29414, '981130', 'juan esteba martinez', 'proyecto numero 44', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:41:23', '2018-01-23', NULL, 1, 1, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29415, '981130', 'juan david marulanda ', 'proyecto numero 45', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:42:56', '2018-01-23', NULL, 0, 1, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29416, '981130', 'juan david marulanda', 'proyecto numero 46', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:44:03', '2018-01-17', NULL, 1, 1, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29417, '981130', 'juan david marulandap', 'proyecto numero 47', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:44:36', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29418, '981130', 'juan esteban coalea', 'proyecto numero 48', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:46:11', '2018-01-24', NULL, 1, 1, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29419, '981130', 'juan camilo pulgarin', 'proyecto numero 49', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:46:59', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL),
(29420, '981130', 'juan david marulandap', 'proyecto numero 50', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2018-01-22 11:48:33', '2018-01-23', NULL, 0, 0, 1, 0, 0, 1, 1, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_negocio`
--

CREATE TABLE `tipo_negocio` (
  `idtipo_negocio` tinyint(4) NOT NULL,
  `nombre` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_negocio`
--

INSERT INTO `tipo_negocio` (`idtipo_negocio`, `nombre`) VALUES
(1, 'Circuito'),
(2, 'Conversor'),
(3, 'Repujado'),
(4, 'Troquel'),
(5, 'Teclado'),
(6, 'Stencil'),
(7, 'PCB'),
(8, 'Circuito GF'),
(9, 'PCB GF'),
(10, 'Circuito COM'),
(11, 'PCB COM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `numero_documento` varchar(13) NOT NULL,
  `tipo_documento` varchar(3) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `apellidos` varchar(30) DEFAULT NULL,
  `cargo_idcargo` tinyint(4) NOT NULL,
  `imagen` longblob,
  `estado` tinyint(1) NOT NULL,
  `contraeña` varchar(20) NOT NULL,
  `sesion` tinyint(1) DEFAULT '0',
  `recuperacion` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`numero_documento`, `tipo_documento`, `nombres`, `apellidos`, `cargo_idcargo`, `imagen`, `estado`, `contraeña`, `sesion`, `recuperacion`) VALUES
('109999999', 'CC', 'juan andresa', 'asdasd', 1, NULL, 1, '109999999', 0, 'citg9j-x56'),
('1216727814', 'CC', 'jhon jairo ', 'sanchez correa', 1, NULL, 1, '1216727814', 0, 'x1ññwula2y'),
('1216727816', 'CC', 'juan david', 'marulanda p', 3, NULL, 1, '98113053240juan', 0, 'wn-gd7c@5q'),
('3004991084', 'CE', 'fredy', 'velez', 1, NULL, 1, '3004991084', 0, '8uifbgjxq1'),
('981130', 'CC', 'sivia hortensia', 'paniagua gomez', 4, NULL, 1, '981130', 0, '1u-hyppy60'),
('98113053', 'CC', 'Catalina', ' rosario', 1, NULL, 0, '98113053', 0, 'bo3t-amybñ'),
('98113053240', 'CC', 'juan david ', 'marulito', 1, NULL, 1, '98113053240', 0, 'i0s2ienq6p'),
('9813053240', 'CC', 'sergio andresss', 'marulanda', 2, NULL, 1, '9813053240', 0, '-8qa2-x54h'),
('99120101605', 'CC', 'sadasd', 'juan andres', 1, NULL, 1, '99120101605', 0, 'ptaeh3a0ab');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`idalmacen`),
  ADD KEY `fk_iddetalleproyecto_amacen` (`detalle_proyecto_idDetalle_proyecto`),
  ADD KEY `fk_idestado_amacen` (`estado_idestado`),
  ADD KEY `fk_proceso_id` (`Procesos_idproceso`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idcargo`);

--
-- Indices de la tabla `detalle_ensamble`
--
ALTER TABLE `detalle_ensamble`
  ADD PRIMARY KEY (`idDetalle_ensamble`,`detalle_proyecto_idDetalle_proyecto`,`Procesos_idproceso`,`estado_idestado`),
  ADD KEY `fk_detalle_teclados_detalle_proyecto1_idx` (`detalle_proyecto_idDetalle_proyecto`),
  ADD KEY `fk_detalle_ensamble_Procesos1_idx` (`Procesos_idproceso`),
  ADD KEY `fk_detalle_ensamble_estado1_idx` (`estado_idestado`);

--
-- Indices de la tabla `detalle_formato_estandar`
--
ALTER TABLE `detalle_formato_estandar`
  ADD PRIMARY KEY (`idDetalle_formato_estandar`,`detalle_proyecto_idDetalle_proyecto`,`Procesos_idproceso`,`estado_idestado`),
  ADD KEY `fk_detalle_formato_estandar_detalle_proyecto1_idx` (`detalle_proyecto_idDetalle_proyecto`),
  ADD KEY `fk_detalle_formato_estandar_Procesos1_idx` (`Procesos_idproceso`),
  ADD KEY `fk_detalle_formato_estandar_estado1_idx` (`estado_idestado`);

--
-- Indices de la tabla `detalle_proyecto`
--
ALTER TABLE `detalle_proyecto`
  ADD PRIMARY KEY (`idDetalle_proyecto`,`tipo_negocio_idtipo_negocio`,`proyecto_numero_orden`,`negocio_idnegocio`,`estado_idestado`),
  ADD KEY `fk_detalle_proyecto_proyecto1_idx` (`proyecto_numero_orden`),
  ADD KEY `fk_detalle_proyecto_tipo_negocio1_idx` (`tipo_negocio_idtipo_negocio`),
  ADD KEY `fk_detalle_proyecto_negocio1_idx` (`negocio_idnegocio`),
  ADD KEY `fk_detalle_proyecto_estado1_idx` (`estado_idestado`);

--
-- Indices de la tabla `detalle_teclados`
--
ALTER TABLE `detalle_teclados`
  ADD PRIMARY KEY (`idDetalle_teclados`,`detalle_proyecto_idDetalle_proyecto`,`Procesos_idproceso`,`estado_idestado`),
  ADD KEY `fk_detalle_teclados_detalle_proyecto1_idx` (`detalle_proyecto_idDetalle_proyecto`),
  ADD KEY `fk_detalle_teclados_Procesos1_idx` (`Procesos_idproceso`),
  ADD KEY `fk_detalle_teclados_estado1_idx` (`estado_idestado`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idestado`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `negocio`
--
ALTER TABLE `negocio`
  ADD PRIMARY KEY (`idnegocio`);

--
-- Indices de la tabla `procesos`
--
ALTER TABLE `procesos`
  ADD PRIMARY KEY (`idproceso`,`negocio_idnegocio`),
  ADD KEY `fk_Procesos_negocio1_idx` (`negocio_idnegocio`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`numero_orden`,`usuario_numero_documento`,`estado_idestado`),
  ADD UNIQUE KEY `numero_orden_UNIQUE` (`numero_orden`),
  ADD KEY `fk_proyecto_usuario_idx` (`usuario_numero_documento`),
  ADD KEY `fk_proyecto_estado1_idx` (`estado_idestado`);

--
-- Indices de la tabla `tipo_negocio`
--
ALTER TABLE `tipo_negocio`
  ADD PRIMARY KEY (`idtipo_negocio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`numero_documento`,`cargo_idcargo`),
  ADD UNIQUE KEY `numero_documento_UNIQUE` (`numero_documento`),
  ADD KEY `fk_usuario_cargo1_idx` (`cargo_idcargo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `idalmacen` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idcargo` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `detalle_ensamble`
--
ALTER TABLE `detalle_ensamble`
  MODIFY `idDetalle_ensamble` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `detalle_formato_estandar`
--
ALTER TABLE `detalle_formato_estandar`
  MODIFY `idDetalle_formato_estandar` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2344;

--
-- AUTO_INCREMENT de la tabla `detalle_proyecto`
--
ALTER TABLE `detalle_proyecto`
  MODIFY `idDetalle_proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=613;

--
-- AUTO_INCREMENT de la tabla `detalle_teclados`
--
ALTER TABLE `detalle_teclados`
  MODIFY `idDetalle_teclados` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `idestado` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `negocio`
--
ALTER TABLE `negocio`
  MODIFY `idnegocio` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `procesos`
--
ALTER TABLE `procesos`
  MODIFY `idproceso` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `numero_orden` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29421;

--
-- AUTO_INCREMENT de la tabla `tipo_negocio`
--
ALTER TABLE `tipo_negocio`
  MODIFY `idtipo_negocio` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD CONSTRAINT `fk_iddetalleproyecto_amacen` FOREIGN KEY (`detalle_proyecto_idDetalle_proyecto`) REFERENCES `detalle_proyecto` (`idDetalle_proyecto`),
  ADD CONSTRAINT `fk_idestado_amacen` FOREIGN KEY (`estado_idestado`) REFERENCES `estado` (`idestado`),
  ADD CONSTRAINT `fk_proceso_id` FOREIGN KEY (`Procesos_idproceso`) REFERENCES `procesos` (`idproceso`);

--
-- Filtros para la tabla `detalle_ensamble`
--
ALTER TABLE `detalle_ensamble`
  ADD CONSTRAINT `fk_detalle_ensamble_Procesos1` FOREIGN KEY (`Procesos_idproceso`) REFERENCES `procesos` (`idproceso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_ensamble_estado1` FOREIGN KEY (`estado_idestado`) REFERENCES `estado` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_teclados_detalle_proyecto10` FOREIGN KEY (`detalle_proyecto_idDetalle_proyecto`) REFERENCES `detalle_proyecto` (`idDetalle_proyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_formato_estandar`
--
ALTER TABLE `detalle_formato_estandar`
  ADD CONSTRAINT `fk_detalle_formato_estandar_Procesos1` FOREIGN KEY (`Procesos_idproceso`) REFERENCES `procesos` (`idproceso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_formato_estandar_detalle_proyecto1` FOREIGN KEY (`detalle_proyecto_idDetalle_proyecto`) REFERENCES `detalle_proyecto` (`idDetalle_proyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_formato_estandar_estado1` FOREIGN KEY (`estado_idestado`) REFERENCES `estado` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_proyecto`
--
ALTER TABLE `detalle_proyecto`
  ADD CONSTRAINT `fk_detalle_proyecto_estado1` FOREIGN KEY (`estado_idestado`) REFERENCES `estado` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_proyecto_negocio1` FOREIGN KEY (`negocio_idnegocio`) REFERENCES `negocio` (`idnegocio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_proyecto_proyecto1` FOREIGN KEY (`proyecto_numero_orden`) REFERENCES `proyecto` (`numero_orden`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_proyecto_tipo_negocio1` FOREIGN KEY (`tipo_negocio_idtipo_negocio`) REFERENCES `tipo_negocio` (`idtipo_negocio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_teclados`
--
ALTER TABLE `detalle_teclados`
  ADD CONSTRAINT `fk_detalle_teclados_Procesos1` FOREIGN KEY (`Procesos_idproceso`) REFERENCES `procesos` (`idproceso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_teclados_detalle_proyecto1` FOREIGN KEY (`detalle_proyecto_idDetalle_proyecto`) REFERENCES `detalle_proyecto` (`idDetalle_proyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_teclados_estado1` FOREIGN KEY (`estado_idestado`) REFERENCES `estado` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `procesos`
--
ALTER TABLE `procesos`
  ADD CONSTRAINT `fk_Procesos_negocio1` FOREIGN KEY (`negocio_idnegocio`) REFERENCES `negocio` (`idnegocio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `fk_proyecto_estado1` FOREIGN KEY (`estado_idestado`) REFERENCES `estado` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_proyecto_usuario` FOREIGN KEY (`usuario_numero_documento`) REFERENCES `usuario` (`numero_documento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_cargo1` FOREIGN KEY (`cargo_idcargo`) REFERENCES `cargo` (`idcargo`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
