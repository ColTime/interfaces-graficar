-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2017 a las 22:43:48
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7

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
#DECLARE tipoN int;#Inicializar variablesSET iniciar=(SELECT d.pro_porIniciar FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);
SET pausar=(SELECT d.pro_Pausado FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);
SET ejecucion=(SELECT d.pro_Ejecucion FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);
SET terminar=(SELECT d.pro_Terminado FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);

IF negocio=1 THEN 
#SET tipoN = (SELECT d.tipo_negocio_idtipo_negocio FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);
IF (iniciar+pausar+ejecucion+terminar)=terminar AND iniciar=0 AND pausar=0 and ejecucion=0 THEN

UPDATE detalle_proyecto d SET d.estado_idestado=3 WHERE d.idDetalle_proyecto=detalle;
ELSE
 IF iniciar!=0 AND pausar=0 AND ejecucion=0 and terminar=0 THEN
  UPDATE detalle_proyecto d SET d.estado_idestado=1 WHERE d.idDetalle_proyecto=detalle;
  END IF;
 IF ejecucion>=1 THEN
  UPDATE detalle_proyecto d SET d.estado_idestado=4 WHERE d.idDetalle_proyecto=detalle;
 ELSE
  IF pausar!=0 and ejecucion=0 and terminar=0 THEN
    UPDATE detalle_proyecto d SET d.estado_idestado=2 WHERE d.idDetalle_proyecto=detalle;
  ELSE
   IF pausar!=0 and ejecucion=0 and terminar!=0 THEN
    UPDATE detalle_proyecto d SET d.estado_idestado=2 WHERE d.idDetalle_proyecto=detalle;
   ELSE
    IF pausar=0 and ejecucion=0 and terminar!=0 AND iniciar!=0 THEN
    UPDATE detalle_proyecto d SET d.estado_idestado=2 WHERE d.idDetalle_proyecto=detalle;
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
 IF pausar!=0 and ejecucion=0 and terminar=0 THEN
    UPDATE detalle_proyecto d SET d.estado_idestado=2 WHERE d.idDetalle_proyecto=detalle;
  ELSE 
    IF pausar!=0 and ejecucion=0 and terminar!=0 THEN
    UPDATE detalle_proyecto d SET d.estado_idestado=2 WHERE d.idDetalle_proyecto=detalle;
    ELSE
   IF terminar!=0 AND ejecucion=0 AND pausar=0 THEN
        CALL PA_CambiarEstadoTerminadoTEIN(negocio,detalle);
   END IF;
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
 
IF iniciar!=0 AND pausar=0 AND terminado=0 AND ejecucion=0 THEN
UPDATE proyecto p SET p.estado_idestado=1, p.fecha_salidal=null WHERE p.numero_orden = orden;
END IF;
 
IF (iniciar+pausar+ejecucion+terminado)=terminado and iniciar=0 AND pausar=0 and ejecucion=0 THEN
UPDATE proyecto p SET p.estado_idestado=3, p.fecha_salidal=(SELECT NOW()) WHERE p.numero_orden = orden;
ELSE
 IF (ejecucion!=0)and(pausar!=0 or pausar=0) and (terminado!=0 or terminado=0) THEN
  UPDATE proyecto p SET p.estado_idestado=4, p.fecha_salidal=null WHERE p.numero_orden = orden;
 ELSE
  IF pausar!=0 and (terminado=0 or terminado !=0) and ejecucion=0 THEN
    UPDATE proyecto p SET p.estado_idestado=2, p.fecha_salidal=null WHERE p.numero_orden = orden;
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

 IF EXISTS(SELECT d.estado_idestado FROM detalle_ensamble d where    d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=18 AND d.estado_idestado=3) THEN

 SET res= true;
 
 ELSE 

 SET res = false;
 
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

SELECT COUNT(*),dp.negocio_idnegocio FROM detalle_proyecto dp WHERE dp.estado_idestado=4 AND dp.PNC=0 GROUP BY dp.negocio_idnegocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CantidadProyectosIngresadosArea` ()  NO SQL
BEGIN

SELECT COUNT(dp.idDetalle_proyecto) as catidadIngresada ,dp.negocio_idnegocio FROM detalle_proyecto dp JOIN proyecto p ON dp.proyecto_numero_orden=p.numero_orden WHERE DATE_FORMAT(p.fecha_ingreso,'%Y -%m -%d')=DATE_FORMAT(CURRENT_DATE,'%Y -%m -%d') GROUP BY dp.negocio_idnegocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CantidadProyectosPorIniciar` ()  NO SQL
BEGIN

SELECT COUNT(*),dp.negocio_idnegocio FROM detalle_proyecto dp WHERE dp.estado_idestado=1 AND dp.PNC=0 GROUP BY dp.negocio_idnegocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CantidadProyectosterminadosHoy` ()  NO SQL
BEGIN
DECLARE FE INT;
DECLARE TE INT;
DECLARE EN INT;

SET FE =(SELECT COUNT(*) FROM detalle_formato_estandar df JOIN detalle_proyecto dp ON df.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto WHERE DATE_FORMAT(df.fecha_fin,'%Y-%m-%d')=DATE_FORMAT(CURRENT_DATE,'%Y-%m-%d') AND df.Procesos_idproceso=10 AND dp.estado_idestado=3 AND df.estado_idestado=3);

SET TE =(SELECT COUNT(*) FROM detalle_teclados dt JOIN detalle_proyecto dp ON dt.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto WHERE DATE_FORMAT(dt.fecha_fin,'%Y-%m-%d')=DATE_FORMAT(CURRENT_DATE,'%Y-%m-%d') AND dt.Procesos_idproceso=14 AND dp.estado_idestado=3 AND dt.estado_idestado=3);

SET EN =(SELECT COUNT(*) FROM detalle_ensamble de JOIN detalle_proyecto dp ON de.detalle_proyecto_idDetalle_proyecto=dp.idDetalle_proyecto WHERE DATE_FORMAT(de.fecha_fin,'%Y-%m-%d')=DATE_FORMAT(CURRENT_DATE,'%Y-%m-%d') AND de.Procesos_idproceso=18 AND dp.estado_idestado=3 AND de.estado_idestado=3);

SELECT FE,TE,EN;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarDetalleProyecto` (IN `orden` INT(11))  NO SQL
SELECT d.idDetalle_proyecto,n.nom_negocio,t.nombre,d.canitadad_total,e.nombre as estado, d.PNC,d.ubicacion,d.material FROM tipo_negocio t  JOIN detalle_proyecto d on t.idtipo_negocio=d.tipo_negocio_idtipo_negocio JOIN negocio n on d.negocio_idnegocio=n.idnegocio JOIN estado e on d.estado_idestado=e.idestado WHERE d.proyecto_numero_orden=orden$$

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

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarProyectosEntrega` (IN `orden` INT, IN `nombreC` VARCHAR(45), IN `nombreP` VARCHAR(45), IN `fecha` VARCHAR(10))  NO SQL
BEGIN

IF orden='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado;
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%');
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%');
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%');
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%');
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
              ELSE 
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;                                   
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
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado; 
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%');
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%');
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%');
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%');
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
              ELSE
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;                                   
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
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado;
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%');
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%');
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%');
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%');
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
              ELSE
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteoC,p.antisolderC,p.ruteoP,p.antisolderP FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;                                   
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
SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo;
ELSE
  IF doc!='' AND nombreApe='' and cargo=0 THEN
	SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.numero_documento LIKE CONCAT(doc, '%');
 ELSE
     IF doc='' AND nombreApe!='' and cargo=0 THEN 
	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.nombres like CONCAT('%', nombreApe, '%') or u.apellidos like CONCAT('%', nombreApe, '%');
     ELSE
        IF doc='' AND nombreApe='' and cargo!=0 THEN
        	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.cargo_idcargo =cargo;
        ELSE
            IF doc='' AND nombreApe!='' and cargo!=0 THEN
            	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.cargo_idcargo =cargo AND u.nombres like CONCAT('%', nombreApe, '%') or u.apellidos like CONCAT('%', nombreApe, '%');
             ELSE
              IF doc!='' AND nombreApe!='' and cargo!=0 THEN
                          	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.cargo_idcargo =cargo AND u.numero_documento LIKE CONCAT(doc, '%') AND (u.nombres like CONCAT('%', nombreApe, '%') or u.apellidos like CONCAT('%', nombreApe, '%'));         ELSE
                  IF doc!='' AND nombreApe='' and cargo!=0 THEN
                                        	  SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.cargo_idcargo =cargo AND u.numero_documento LIKE CONCAT(doc, '%');
                    ELSE
                    IF doc!='' AND nombreApe!='' and cargo=0 THEN
                     SELECT u.numero_documento,u.tipo_documento,u.nombres,u.apellidos,c.nombre,u.imagen,u.estado FROM usuario u INNER JOIN cargo c on u.cargo_idcargo=c.idcargo WHERE u.numero_documento LIKE CONCAT(doc, '%') AND u.nombres like CONCAT('%', nombreApe, '%') or u.apellidos like CONCAT('%', nombreApe, '%');
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
SELECT p.nombre_proceso,Date_Format(f.fecha_inicio,'%d-%M-%Y') as inicio,Date_format(f.fecha_fin,'%d-%M-%Y') as fin,f.cantidad_terminada,f.tiempo_total_por_proceso,f.tiempo_por_unidad,e.nombre as estado,TIME_FORMAT(f.hora_ejecucion,'%r'),TIME_FORMAT(TIMEDIFF(CURRENT_TIME,f.hora_ejecucion),'%H:%i:%s') as tiempoActual,TIME_FORMAT(f.hora_terminacion,'%r') as "hora terminacion",TIME_FORMAT(TIMEDIFF(TIME_FORMAT(f.hora_terminacion,'%H:%i:%s'),TIME_FORMAT(f.hora_ejecucion,'%H:%i:%s')),'%H:%i:%s') as InicioTerminadoIntervalo,f.idDetalle_formato_estandar FROM detalle_formato_estandar f JOIN procesos p on f.Procesos_idproceso=p.idproceso JOIN estado e on f.estado_idestado=e.idestado where f.detalle_proyecto_idDetalle_proyecto=detalle ORDER BY f.Procesos_idproceso ASC;
ELSE
  IF negocio=2 THEN
  SELECT p.nombre_proceso,Date_Format(f.fecha_inicio,'%d-%M-%Y'),Date_format(f.fecha_fin,'%d-%M-%Y'),f.cantidad_terminada,f.tiempo_total_proceso,f.tiempo_por_unidad,e.nombre,TIME_FORMAT(f.hora_ejecucion,'%r'),TIME_FORMAT(TIMEDIFF(CURRENT_TIME,f.hora_ejecucion),'%H:%i:%s'),TIME_FORMAT(f.hora_terminacion,'%r'),TIME_FORMAT(TIMEDIFF(f.hora_terminacion,f.hora_ejecucion),'%H:%i:%s'),f.idDetalle_teclados FROM detalle_teclados f JOIN procesos p on f.Procesos_idproceso=p.idproceso JOIN estado e on f.estado_idestado=e.idestado where f.detalle_proyecto_idDetalle_proyecto=detalle ORDER BY f.Procesos_idproceso ASC;
  ELSE
   IF negocio=3 THEN
SELECT p.nombre_proceso,Date_Format(f.fecha_inicio,'%d-%M-%Y'),Date_format(f.fecha_fin,'%d-%M-%Y'),f.cantidad_terminada,f.tiempo_total_por_proceso,f.tiempo_por_unidad,e.nombre,TIME_FORMAT(f.hora_ejecucion,'%r'),TIME_FORMAT(TIMEDIFF(CURRENT_TIME,f.hora_ejecucion),'%H:%i:%s'),TIME_FORMAT(f.hora_terminacion,'%r'),TIME_FORMAT(TIMEDIFF(f.hora_terminacion,f.hora_ejecucion),'%H:%i:%s'),f.idDetalle_ensamble FROM detalle_ensamble f JOIN procesos p on f.Procesos_idproceso=p.idproceso JOIN estado e on f.estado_idestado=e.idestado where f.detalle_proyecto_idDetalle_proyecto=detalle ORDER BY f.Procesos_idproceso ASC;
   END IF;
  END IF;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_DetalleDeProduccionProyectosActivos` (IN `orden` INT, IN `negocio` INT, IN `pnc` INT)  NO SQL
BEGIN

SELECT d.idDetalle_proyecto,t.nombre,d.estado_idestado  FROM detalle_proyecto d JOIN tipo_negocio t on d.tipo_negocio_idtipo_negocio=t.idtipo_negocio WHERE d.proyecto_numero_orden=orden and d.negocio_idnegocio=negocio AND d.PNC=pnc AND d.estado_idestado=4;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_DetalleProyectosProduccion` (IN `orden` INT, IN `negocio` INT, IN `pnc` INT)  NO SQL
BEGIN

SELECT d.idDetalle_proyecto,t.nombre,d.estado_idestado  FROM detalle_proyecto d JOIN tipo_negocio t on d.tipo_negocio_idtipo_negocio=t.idtipo_negocio WHERE d.proyecto_numero_orden=orden and d.negocio_idnegocio=negocio AND d.PNC=pnc;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_Diagramas` ()  NO SQL
BEGIN

SELECT COUNT(*),d.negocio_idnegocio FROM detalle_proyecto d GROUP BY d.negocio_idnegocio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_EliminarNivel3` (IN `orden` INT)  NO SQL
BEGIN



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
SET cantidadP=(SELECT COUNT(numero_orden) FROM proyecto);

SELECT  DATE_FORMAT(CURDATE(),'%d-%M-%Y') as fecha,COUNT(*) as cantidad,cantidadP,d.negocio_idnegocio FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden WHERE d.PNC=0 GROUP BY d.negocio_idnegocio ORDER BY d.negocio_idnegocio ASC;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformacionFiltrariaDetalleProyecto` (IN `iddetalle` INT)  NO SQL
BEGIN

SELECT p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y') as fechaIngreso,DATE_FORMAT(p.fecha_entrega,'%d-%M-%Y')AS fechaEntrega,dp.canitadad_total FROM proyecto p JOIN detalle_proyecto dp ON p.numero_orden=dp.proyecto_numero_orden WHERE dp.idDetalle_proyecto=iddetalle;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_InformacionProyectosProduccion` (IN `negocio` INT, IN `orden` INT, IN `clien` VARCHAR(40), IN `proyecto` VARCHAR(40), IN `tipo` VARCHAR(6))  NO SQL
BEGIN

IF orden=0 AND clien='' AND proyecto='' AND tipo='' THEN
  SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT join proyecto p ON p.numero_orden=d.proyecto_numero_orden where ((p.fecha_salidal is null or p.fecha_salidal is not null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio);
ELSE
 IF orden!=0 AND clien='' AND proyecto='' AND tipo='' THEN
 	 SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT join proyecto p ON p.numero_orden=d.proyecto_numero_orden where ((p.fecha_salidal is null or p.fecha_salidal is not null) and (DATEDIFF(CURRENT_DATE,p.fecha_salidal)<=0 or DATEDIFF(CURRENT_DATE,p.fecha_salidal)is null) and d.negocio_idnegocio=negocio) AND d.proyecto_numero_orden LIKE CONCAT(orden,'%');
 ELSE
  IF orden=0 AND clien!='' AND proyecto='' AND tipo='' THEN
  	  SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where d.negocio_idnegocio=negocio AND         p.nombre_cliente LIKE CONCAT('%',clien,'%');
  ELSE
   IF orden=0 AND clien='' AND proyecto!='' AND tipo='' THEN
   	  SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where d.negocio_idnegocio=negocio AND         p.nombre_proyecto LIKE CONCAT(proyecto,'%');
   ELSE
    IF orden=0 AND clien='' AND proyecto='' AND tipo!='' THEN
       SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where d.negocio_idnegocio=negocio AND        p.tipo_proyecto=tipo;
    ELSE
     IF orden!=0 AND clien!='' AND proyecto='' AND tipo='' THEN
        SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where d.proyecto_numero_orden LIKE           CONCAT(orden,'%') AND p.nombre_cliente LIKE CONCAT('%',clien,'%') AND d.negocio_idnegocio=negocio;
     ELSE 
      IF orden!=0 AND clien='' AND proyecto!='' AND tipo='' THEN
        SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where d.proyecto_numero_orden LIKE           CONCAT(orden,'%') AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') AND d.negocio_idnegocio=negocio;
      ELSE
       IF orden!=0 AND clien='' AND proyecto='' AND tipo!='' THEN
       	 SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where d.proyecto_numero_orden LIKE            CONCAT(orden,'%') AND p.tipo_proyecto=tipo AND d.negocio_idnegocio=negocio;
       ELSE
        IF orden=0 AND clien!='' AND proyecto!='' AND tipo='' THEN
          SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where p.nombre_cliente LIKE                   CONCAT('%',clien,'%') AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') AND d.negocio_idnegocio=negocio;
        ELSE
         IF orden=0 AND clien!='' AND proyecto='' AND tipo!='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where p.nombre_cliente LIKE                  CONCAT('%',clien,'%') AND p.tipo_proyecto=tipo AND d.negocio_idnegocio=negocio;
         ELSE
          IF orden=0 AND clien='' AND proyecto!='' AND tipo!='' THEN
            SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where p.nombre_proyecto LIKE                 CONCAT(proyecto,'%') AND p.tipo_proyecto=tipo AND d.negocio_idnegocio=negocio;
          ELSE
           IF orden!=0 AND clien!='' AND proyecto!='' AND tipo='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where d.proyecto_numero_orden LIKE            CONCAT(orden,'%') AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') AND p.nombre_cliente LIKE CONCAT('%',clien,'%') AND d.negocio_idnegocio=negocio;
           ELSE
            IF orden=0 AND clien!='' AND proyecto!='' AND tipo!='' THEN
             SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where p.tipo_proyecto=tipo AND                p.nombre_proyecto LIKE CONCAT(proyecto,'%') AND p.nombre_cliente LIKE CONCAT('%',clien,'%') AND d.negocio_idnegocio=negocio;
            ELSE
             IF orden!=0 AND clien='' AND proyecto!='' AND tipo!='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on d.proyecto_numero_orden=p.numero_orden where d.proyecto_numero_orden LIKE            CONCAT(orden,'%') AND p.nombre_proyecto LIKE CONCAT(proyecto,'%') AND p.tipo_proyecto=tipo AND d.negocio_idnegocio=negocio;
             ELSE
              IF orden!=0 AND clien!='' AND proyecto='' AND tipo!='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on 
d.proyecto_numero_orden=p.numero_orden where d.proyecto_numero_orden LIKE            CONCAT(orden,'%') AND p.nombre_cliente LIKE 
CONCAT('%',clien,'%') AND p.tipo_proyecto=tipo AND d.negocio_idnegocio=negocio;
              ELSE
               IF orden!=0 AND clien!='' AND proyecto!='' AND tipo!='' THEN
           SELECT DISTINCT(d.proyecto_numero_orden),p.estado_idestado,p.tipo_proyecto FROM detalle_proyecto d RIGHT JOIN proyecto p on 
d.proyecto_numero_orden=p.numero_orden where d.proyecto_numero_orden LIKE            CONCAT(orden,'%') AND p.nombre_cliente LIKE 
CONCAT('%',clien,'%') AND p.nombre_cliente LIKE CONCAT(proyecto,'%') AND p.tipo_proyecto=tipo AND                            
d.negocio_idnegocio=negocio;
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_IniciarRenaudarTomaDeTiempoProcesos` (IN `orden` INT, IN `detalle` INT, IN `lector` INT, IN `busqueda` INT)  NO SQL
BEGIN
DECLARE id int;
DECLARE id1 int;
DECLARE cantidadp int;

IF busqueda=1 THEN

set id=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=1);

set id1=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=2);

IF id !='null' THEN
UPDATE detalle_formato_estandar f SET f.fecha_inicio=CURDATE(), f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME WHERE f.idDetalle_formato_estandar=id;
END IF;

IF id1 !='null' THEN
UPDATE detalle_formato_estandar f SET  f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.hora_terminacion=null WHERE f.idDetalle_formato_estandar=id1;
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
UPDATE detalle_teclados f SET f.fecha_inicio=CURDATE(), f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME WHERE f.idDetalle_teclados=id ;
END IF;

IF id1 !='null' THEN
UPDATE detalle_teclados f SET f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.hora_terminacion=null WHERE f.idDetalle_teclados=id1 ;
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
UPDATE detalle_ensamble f SET f.fecha_inicio=CURDATE(), f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME WHERE f.idDetalle_ensamble=id;
END IF;

IF id1 !='null' THEN
UPDATE detalle_ensamble f SET  f.estado_idestado=4, f.hora_ejecucion=CURRENT_TIME,f.hora_terminacion=null WHERE f.idDetalle_ensamble=id1 ;
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
      CALL PA_CambiarEstadoDeProductos(busqueda,detalle);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ModificarDetalleFormatoEstandar` (IN `orden` INT, IN `detalle` INT, IN `material` VARCHAR(2))  NO SQL
BEGIN
#DECLARE cantidadp int;
IF EXISTS(SELECT * FROM detalle_formato_estandar d  WHERE d.detalle_proyecto_idDetalle_proyecto=detalle AND d.Procesos_idproceso=2) THEN   
  IF material = 'FV' then
     #si no el materia no es "TH" se eliminara este proceso   DELETE FROM detalle_formato_estandar  WHERE detalle_proyecto_idDetalle_proyecto=detalle and Procesos_idproceso=2; 
    #SELECT 'Ya existe TH';     #Fin de la eliminacion     END IF;
ELSE
    IF material='TH' then
    #SELECT 'No existe el TH';     #si el materia es "TH" se registrara este proceso     INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,2,1);
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_PausarTomaDeTiempoDeProcesos` (IN `orden` INT, IN `detalle` INT, IN `lector` INT, IN `busqueda` INT, IN `tiempo` VARCHAR(6), IN `cantidad` INT, IN `est` TINYINT(1))  NO SQL
BEGIN
DECLARE id int;
DECLARE cantidadp int;
IF est=2 THEN

IF busqueda=1 THEN

SET id=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 UPDATE detalle_formato_estandar f SET  f.estado_idestado=est, f.tiempo_total_por_proceso=tiempo,f.cantidad_terminada=cantidad WHERE f.idDetalle_formato_estandar=id ;

ELSE
 IF busqueda=2 THEN
 
 SET id=(SELECT f.idDetalle_teclados from detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 UPDATE detalle_teclados f SET  f.estado_idestado=est, f.tiempo_total_proceso=tiempo, f.cantidad_terminada=cantidad WHERE f.idDetalle_teclados=id ;
 
 ELSE
  IF busqueda=3 THEN
  
  SET id=(SELECT f.idDetalle_ensamble from detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
  
  UPDATE detalle_ensamble f SET  f.estado_idestado=est, f.tiempo_total_por_proceso=tiempo,f.cantidad_terminada=cantidad WHERE f.idDetalle_ensamble=id ;
  
  END IF; 
 END IF;
END IF;

ELSE

IF busqueda=1 THEN

SET id=(SELECT f.idDetalle_formato_estandar from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 UPDATE detalle_formato_estandar f SET  f.estado_idestado=est,f.fecha_fin=CURRENT_DATE,f.tiempo_total_por_proceso=tiempo,f.cantidad_terminada=cantidad WHERE f.idDetalle_formato_estandar=id ;

ELSE
 IF busqueda=2 THEN
 
 SET id=(SELECT f.idDetalle_teclados from detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 UPDATE detalle_teclados f SET  f.estado_idestado=est,f.fecha_fin=CURRENT_DATE, f.tiempo_total_proceso=tiempo, f.cantidad_terminada=cantidad WHERE f.idDetalle_teclados=id ;
 
 ELSE
  IF busqueda=3 THEN
  
  SET id=(SELECT f.idDetalle_ensamble from detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
  
  UPDATE detalle_ensamble f SET  f.estado_idestado=est,f.fecha_fin=CURRENT_DATE, f.tiempo_total_por_proceso=tiempo,f.cantidad_terminada=cantidad WHERE f.idDetalle_ensamble=id;
  
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleEnsamble` (IN `proceso` TINYINT, IN `orden` INT, IN `tipo` INT, IN `ubic` VARCHAR(25))  NO SQL
BEGIN

DECLARE detalle int;

IF ubic='' THEN
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=3 AND dd.ubicacion is null));

ELSE
 
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=3 AND dd.ubicacion=ubic));

END IF;

INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('00:00','00:00','0',detalle,proceso,1);

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
#ELSE#DELETE FROM detalle_formato_estandar  WHERE detalle_proyecto_idDetalle_proyecto=detalle AND Procesos_idproceso=2; END IF;


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

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleTeclados` (IN `proceso` INT, IN `orden` INT, IN `tipo` INT, IN `ubic` VARCHAR(25))  NO SQL
BEGIN

DECLARE detalle int;

IF ubic='' THEN
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=2 AND dd.ubicacion is null));

ELSE
 
set detalle=((SELECT dd.idDetalle_proyecto from detalle_proyecto dd WHERE dd.proyecto_numero_orden=(orden) AND dd.tipo_negocio_idtipo_negocio=tipo AND dd.negocio_idnegocio=2 AND dd.ubicacion=ubic));

END IF;

INSERT INTO `detalle_teclados`(`tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`)VALUES
('00:00','00:00','0',detalle,proceso,1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_Sesion` (IN `sec` INT, IN `ced` VARCHAR(13))  NO SQL
BEGIN

UPDATE usuario u SET u.sesion=sec WHERE u.numero_documento=ced;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarCantidadDetalleProyecto` (IN `orden` INT, IN `detalle` INT, IN `lector` INT, IN `busqueda` INT)  NO SQL
BEGIN

DECLARE can int;
DECLARE id int;

IF busqueda=1 THEN

SET id=(SELECT f.cantidad_terminada from detalle_formato_estandar f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);

ELSE
 IF busqueda=2 THEN
 
 SET id=(SELECT f.cantidad_terminada from detalle_teclados f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
 
 ELSE
  IF busqueda=3 THEN
  
  SET id=(SELECT f.cantidad_terminada from detalle_ensamble f JOIN detalle_proyecto d on f.detalle_proyecto_idDetalle_proyecto=d.idDetalle_proyecto where d.proyecto_numero_orden=orden AND d.idDetalle_proyecto=detalle and f.Procesos_idproceso=lector and f.estado_idestado=4);
  
  END IF; 
 END IF;
END IF;
set can=(select d.canitadad_total FROM detalle_proyecto d WHERE d.idDetalle_proyecto=detalle);

SELECT can as contidad_total,id as cantidad_proceso;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarCantidadPNCOrigen` (IN `orden` INT, IN `detalle` INT, IN `op` INT, IN `tipo` INT, IN `negocio` INT)  NO SQL
BEGIN

IF op=1 THEN

 SELECT d.canitadad_total FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden and d.idDetalle_proyecto=detalle;

else

SELECT d.canitadad_total FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden and d.PNC=0 and d.negocio_idnegocio=negocio AND d.tipo_negocio_idtipo_negocio=tipo;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_validarPNC` (IN `orden` INT, IN `proceso` VARCHAR(30))  NO SQL
BEGIN

SELECT p.idDetalle_proyecto FROM detalle_proyecto p WHERE p.ubicacion=proceso and p.proyecto_numero_orden=orden;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarUbicacionPNC` (IN `orden` INT, IN `ubicacion` VARCHAR(50))  NO SQL
BEGIN

IF EXISTS(SELECT * FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.PNC=1 and d.ubicacion=ubicacion) THEN
SELECT d.idDetalle_proyecto FROM detalle_proyecto d WHERE d.proyecto_numero_orden=orden AND d.PNC=1 and d.ubicacion=ubicacion;

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

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_EliminarDetalleProyectoEnsamble` (`iddetalle` INT, `orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE cantidad int;
SET cantidad=(SELECT count(*) from detalle_ensamble f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);

IF cantidad=0 THEN
DELETE FROM `detalle_ensamble` WHERE detalle_proyecto_idDetalle_proyecto=iddetalle;

DELETE FROM `detalle_proyecto` WHERE idDetalle_proyecto=iddetalle;
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
RETURN 1;
ELSE
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

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_InsertarModificarUsuar` (`_doc` VARCHAR(13), `_tipo` VARCHAR(3), `_nombre` VARCHAR(30), `_apellido` VARCHAR(30), `_cargo` TINYINT, `_estado` TINYINT, `op` TINYINT) RETURNS TINYINT(1) READS SQL DATA
BEGIN
 DECLARE val varchar(13);
if op=1 THEN
SET val=(SELECT numero_documento FROM usuario WHERE    numero_documento=_doc);
  IF val=_doc THEN
     RETURN 0;
 ELSE 
     INSERT INTO        usuario(numero_documento,tipo_documento,nombres,apellidos,cargo_idcargo,estado,contraeña)   VALUES (_doc,_tipo,_nombre,_apellido,_cargo,_estado,_doc);
  return 1;
  
END IF;
ELSE
UPDATE usuario SET tipo_documento=_tipo,nombres=_nombre, apellidos=_apellido, cargo_idcargo=_cargo,estado=_estado where  numero_documento=_doc;
RETURN 1;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ModificarDetalleProyecto` (`orden` INT, `idDetalle` INT, `cantidad` VARCHAR(6), `material` VARCHAR(6), `negocio` INT) RETURNS TINYINT(1) NO SQL
BEGIN
UPDATE `detalle_proyecto` SET `canitadad_total`=cantidad,`material`=material WHERE idDetalle_proyecto=idDetalle and proyecto_numero_orden=orden;
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

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_RegistrarModificarProyecto` (`doc` VARCHAR(13), `cliente` VARCHAR(30), `proyecto` VARCHAR(30), `tipo` VARCHAR(6), `fe` TINYINT(1), `te` TINYINT(1), `inte` TINYINT(1), `pcbfe` TINYINT(1), `pcbte` TINYINT(1), `conv` TINYINT(1), `rep` TINYINT(1), `tro` TINYINT(1), `st` TINYINT(1), `lexan` TINYINT(1), `entrega` VARCHAR(10), `ruteo` TINYINT(1), `anti` TINYINT(1), `norden` INT, `op` TINYINT(1), `ruteoP` TINYINT(1), `antiP` TINYINT(1)) RETURNS TINYINT(11) NO SQL
IF op=1 THEN

INSERT INTO `proyecto`(`numero_orden`,`usuario_numero_documento`, `nombre_cliente`, `nombre_proyecto`, `tipo_proyecto`, `FE`, `TE`, `IN`, `pcb_FE`, `pcb_TE`, `Conversor`, `Repujado`, `troquel`, `stencil`, `lexan`, `fecha_ingreso`, `fecha_entrega`, `ruteoC`, `antisolderC`, `estado_idestado`,`ruteoP`,`antisolderP`) VALUES (norden,doc,cliente,proyecto,tipo,fe,te,inte,pcbfe,pcbte,conv,rep,tro,st,lexan,(SELECT now()),entrega,ruteo,anti,1,ruteoP,antiP);
RETURN 1;
ELSE 
 UPDATE `proyecto` SET `nombre_cliente`=cliente,`nombre_proyecto`=proyecto,`tipo_proyecto`=tipo,`FE`=fe,`TE`=te,`IN`=inte,`pcb_FE`=pcbfe,`pcb_TE`=pcbte,`Conversor`=conv,`Repujado`=rep,`troquel`=tro,`stencil`=st,`lexan`=lexan,`fecha_entrega`=entrega,`ruteoC`=ruteo,`antisolderC`=anti,`ruteoP`=ruteoP,`antisolderP`=antiP WHERE numero_orden=norden;
RETURN 1;
END IF$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ReiniciarTiempo` (`detalle` INT, `negocio` INT) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE cantidadp int;
DECLARE detalleN int;


IF negocio=1 THEN
#Formato estandarUPDATE `detalle_formato_estandar` SET `tiempo_por_unidad`= "00:00",`tiempo_total_por_proceso`="00:00",`cantidad_terminada`=0,`fecha_inicio`=null,`fecha_fin`=null,`estado_idestado`=1,`hora_ejecucion`=null,`hora_terminacion`=null WHERE `idDetalle_formato_estandar`=detalle;
#Se actualizan la cantidad de proyectos que estan en diferentes estados de los proyectos de FESET detalleN =(SELECT d.detalle_proyecto_idDetalle_proyecto FROM detalle_formato_estandar d WHERE d.idDetalle_formato_estandar=detalle);

 SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_formato_estandar d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalleN;
#Se cambia del detalle del proyectoCALL PA_CambiarEstadoDeProductos(negocio,detalleN);
  RETURN 1;
ELSE
 IF negocio=2 THEN
 #TecladosUPDATE `detalle_teclados` SET `tiempo_por_unidad`= "00:00",`tiempo_total_proceso`="00:00",`cantidad_terminada`=0,`fecha_inicio`=null,`fecha_fin`=null,`estado_idestado`=1,`hora_ejecucion`=null,`hora_terminacion`=null WHERE `idDetalle_teclados`=detalle;
#Se actualizan la cantidad de proyectos que estan en diferentes estados de los proyectos de TESET detalleN =(SELECT d.detalle_proyecto_idDetalle_proyecto FROM detalle_teclados d WHERE d.idDetalle_teclados=detalle);

 SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_teclados d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalleN;
#Se cambia del detalle del proyectoCALL PA_CambiarEstadoDeProductos(negocio,detalleN);
 RETURN 1;
 ELSE
  #EnsambleUPDATE `detalle_ensamble` SET `tiempo_por_unidad`= "00:00",`tiempo_total_por_proceso`="00:00",`cantidad_terminada`=0,`fecha_inicio`=null,`fecha_fin`=null,`estado_idestado`=1,`hora_ejecucion`=null,`hora_terminacion`=null WHERE `idDetalle_ensamble`=detalle;
#Se actualizan la cantidad de proyectos que estan en diferentes estados de los proyectos de ENSET detalleN =(SELECT d.detalle_proyecto_idDetalle_proyecto FROM detalle_ensamble d WHERE d.idDetalle_ensamble=detalle);

 SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=1);

UPDATE detalle_proyecto SET pro_porIniciar=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=2);

UPDATE detalle_proyecto SET pro_Pausado=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=4);

UPDATE detalle_proyecto SET pro_Ejecucion=cantidadp WHERE idDetalle_proyecto=detalleN;

SET cantidadp =(SELECT COUNT(*) FROM detalle_ensamble d WHERE  d.detalle_proyecto_idDetalle_proyecto=(detalleN) AND d.estado_idestado=3);

UPDATE detalle_proyecto SET pro_Terminado=cantidadp WHERE idDetalle_proyecto=detalleN;
#Se cambia del detalle del proyectoCALL PA_CambiarEstadoDeProductos(negocio,detalleN);
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
#VariablesDECLARE cantidad int;

IF busqueda=1 THEN
 #Formato estandar SET cantidad=(SELECT count(*) from detalle_formato_estandar f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);   
IF cantidad=0 THEN
RETURN 1;
ELSE
RETURN 0;
END IF;
 #Fin de formato estandarELSE
 IF busqueda=2 THEN
 #TecladosSET cantidad=(SELECT count(*) from detalle_teclados f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);
IF cantidad=0 THEN
RETURN 1;
ELSE
RETURN 0;
END IF;
 #Fin de teclados ELSE
  IF busqueda=3 THEN
  #Ensamble  SET cantidad=(SELECT count(*) from detalle_ensamble f INNER JOIN detalle_proyecto d  WHERE f.detalle_proyecto_idDetalle_proyecto=iddetalle AND f.fecha_inicio is not null and d.proyecto_numero_orden=orden);

IF cantidad=0 THEN
RETURN 1;
ELSE
RETURN 0;
END IF;
  #Fin de ensamble  END IF;
 END if;
END IF;

END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ValidarNumerOrden` (`orden` INT) RETURNS TINYINT(1) NO SQL
BEGIN

IF EXISTS(SELECT * FROM proyecto d WHERE d.numero_orden=orden) THEN
# si el proyecto con ese numero de orden existe retorna un trueRETURN 1;
ELSE
# si el proyecto con ese numero de orden no existe retorna un falseRETURN 0;
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
  `hora_terminacion` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_ensamble`
--

INSERT INTO `detalle_ensamble` (`idDetalle_ensamble`, `tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`, `hora_ejecucion`, `hora_terminacion`) VALUES
(1, '00:00', '00:00', '0', NULL, NULL, 186, 15, 1, NULL, NULL),
(2, '00:00', '00:00', '0', NULL, NULL, 186, 16, 1, NULL, NULL),
(3, '00:00', '00:00', '0', NULL, NULL, 186, 17, 1, NULL, NULL),
(4, '00:00', '00:00', '0', NULL, NULL, 186, 18, 1, NULL, NULL),
(5, '00:00', '00:00', '0', NULL, NULL, 186, 19, 1, NULL, NULL),
(6, '00:00', '00:00', '0', NULL, NULL, 186, 20, 1, NULL, NULL),
(7, '00:00', '00:00', '0', NULL, NULL, 186, 21, 1, NULL, NULL),
(8, '00:00', '00:00', '0', NULL, NULL, 194, 15, 1, NULL, NULL),
(9, '00:00', '00:00', '0', NULL, NULL, 194, 16, 1, NULL, NULL),
(10, '00:00', '00:00', '0', NULL, NULL, 194, 17, 1, NULL, NULL),
(11, '00:00', '00:00', '0', NULL, NULL, 194, 18, 1, NULL, NULL),
(12, '00:00', '00:00', '0', NULL, NULL, 194, 19, 1, NULL, NULL),
(13, '00:00', '00:00', '0', NULL, NULL, 194, 20, 1, NULL, NULL),
(14, '00:00', '00:00', '0', NULL, NULL, 194, 21, 1, NULL, NULL),
(22, '00:00', '00:00', '0', NULL, NULL, 222, 15, 1, NULL, NULL),
(23, '00:00', '00:00', '0', NULL, NULL, 222, 16, 1, NULL, NULL),
(24, '00:00', '00:00', '0', NULL, NULL, 222, 17, 1, NULL, NULL),
(25, '00:00', '00:00', '0', NULL, NULL, 222, 18, 1, NULL, NULL),
(26, '00:00', '00:00', '0', NULL, NULL, 222, 19, 1, NULL, NULL),
(27, '00:00', '00:00', '0', NULL, NULL, 222, 20, 1, NULL, NULL),
(28, '00:00', '00:00', '0', NULL, NULL, 222, 21, 1, NULL, NULL);

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
  `hora_terminacion` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_formato_estandar`
--

INSERT INTO `detalle_formato_estandar` (`idDetalle_formato_estandar`, `tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`, `hora_ejecucion`, `hora_terminacion`) VALUES
(803, '00:00', '00:00', '0', NULL, NULL, 143, 1, 1, NULL, NULL),
(804, '00:00', '00:00', '0', NULL, NULL, 143, 2, 1, NULL, NULL),
(805, '00:00', '00:00', '0', NULL, NULL, 143, 3, 1, NULL, NULL),
(806, '00:00', '00:00', '0', NULL, NULL, 143, 4, 1, NULL, NULL),
(807, '00:00', '00:00', '0', NULL, NULL, 143, 5, 1, NULL, NULL),
(808, '00:00', '00:00', '0', NULL, NULL, 143, 6, 1, NULL, NULL),
(809, '00:00', '00:00', '0', NULL, NULL, 143, 7, 1, NULL, NULL),
(810, '00:00', '00:00', '0', NULL, NULL, 143, 8, 1, NULL, NULL),
(812, '00:00', '00:00', '0', NULL, NULL, 143, 10, 1, NULL, NULL),
(886, '00:00', '00:00', '0', NULL, NULL, 170, 1, 1, NULL, NULL),
(887, '00:00', '00:00', '0', NULL, NULL, 170, 3, 1, NULL, NULL),
(888, '00:00', '00:00', '0', NULL, NULL, 170, 4, 1, NULL, NULL),
(889, '00:00', '00:00', '0', NULL, NULL, 170, 5, 1, NULL, NULL),
(890, '00:00', '00:00', '0', NULL, NULL, 170, 7, 1, NULL, NULL),
(891, '00:00', '00:00', '0', NULL, NULL, 170, 8, 1, NULL, NULL),
(892, '00:00', '00:00', '0', NULL, NULL, 170, 10, 1, NULL, NULL),
(893, '00:00', '00:00', '0', NULL, NULL, 171, 1, 1, NULL, NULL),
(895, '00:00', '00:00', '0', NULL, NULL, 171, 3, 1, NULL, NULL),
(896, '00:00', '00:00', '0', NULL, NULL, 171, 4, 1, NULL, NULL),
(897, '00:00', '00:00', '0', NULL, NULL, 171, 5, 1, NULL, NULL),
(898, '00:00', '00:00', '0', NULL, NULL, 171, 7, 1, NULL, NULL),
(899, '00:00', '00:00', '0', NULL, NULL, 171, 8, 1, NULL, NULL),
(900, '00:00', '00:00', '0', NULL, NULL, 171, 10, 1, NULL, NULL),
(915, '00:00', '00:00', '0', NULL, NULL, 178, 1, 1, NULL, NULL),
(916, '00:00', '00:00', '0', NULL, NULL, 178, 4, 1, NULL, NULL),
(925, '00:00', '00:00', '0', NULL, NULL, 180, 1, 1, NULL, NULL),
(926, '00:00', '00:00', '0', NULL, NULL, 180, 3, 1, NULL, NULL),
(927, '00:00', '00:00', '0', NULL, NULL, 180, 4, 1, NULL, NULL),
(928, '00:00', '00:00', '0', NULL, NULL, 180, 5, 1, NULL, NULL),
(929, '00:00', '00:00', '0', NULL, NULL, 180, 7, 1, NULL, NULL),
(930, '00:00', '00:00', '0', NULL, NULL, 180, 8, 1, NULL, NULL),
(931, '00:00', '00:00', '0', NULL, NULL, 180, 9, 1, NULL, NULL),
(932, '00:00', '00:00', '0', NULL, NULL, 180, 10, 1, NULL, NULL),
(933, '00:00', '00:00', '0', NULL, NULL, 181, 1, 1, NULL, NULL),
(934, '00:00', '00:00', '0', NULL, NULL, 181, 2, 1, NULL, NULL),
(935, '00:00', '00:00', '0', NULL, NULL, 181, 3, 1, NULL, NULL),
(936, '00:00', '00:00', '0', NULL, NULL, 181, 4, 1, NULL, NULL),
(937, '00:00', '00:00', '0', NULL, NULL, 181, 5, 1, NULL, NULL),
(938, '00:00', '00:00', '0', NULL, NULL, 181, 6, 1, NULL, NULL),
(939, '00:00', '00:00', '0', NULL, NULL, 181, 7, 1, NULL, NULL),
(940, '00:00', '00:00', '0', NULL, NULL, 181, 8, 1, NULL, NULL),
(941, '00:00', '00:00', '0', NULL, NULL, 181, 9, 1, NULL, NULL),
(942, '00:00', '00:00', '0', NULL, NULL, 181, 10, 1, NULL, NULL),
(943, '00:00', '00:00', '0', NULL, NULL, 182, 1, 1, NULL, NULL),
(944, '00:00', '00:00', '0', NULL, NULL, 182, 2, 1, NULL, NULL),
(945, '00:00', '00:00', '0', NULL, NULL, 182, 3, 1, NULL, NULL),
(946, '00:00', '00:00', '0', NULL, NULL, 182, 4, 1, NULL, NULL),
(947, '00:00', '00:00', '0', NULL, NULL, 182, 5, 1, NULL, NULL),
(948, '00:00', '00:00', '0', NULL, NULL, 182, 6, 1, NULL, NULL),
(949, '00:00', '00:00', '0', NULL, NULL, 182, 7, 1, NULL, NULL),
(950, '00:00', '00:00', '0', NULL, NULL, 182, 8, 1, NULL, NULL),
(951, '00:00', '00:00', '0', NULL, NULL, 182, 9, 1, NULL, NULL),
(952, '00:00', '00:00', '0', NULL, NULL, 182, 10, 1, NULL, NULL),
(953, '00:00', '00:00', '0', NULL, NULL, 183, 1, 1, NULL, NULL),
(954, '00:00', '00:00', '0', NULL, NULL, 183, 3, 1, NULL, NULL),
(955, '00:00', '00:00', '0', NULL, NULL, 183, 4, 1, NULL, NULL),
(956, '00:00', '00:00', '0', NULL, NULL, 183, 5, 1, NULL, NULL),
(957, '00:00', '00:00', '0', NULL, NULL, 183, 7, 1, NULL, NULL),
(958, '00:00', '00:00', '0', NULL, NULL, 183, 8, 1, NULL, NULL),
(959, '00:00', '00:00', '0', NULL, NULL, 183, 9, 1, NULL, NULL),
(960, '00:00', '00:00', '0', NULL, NULL, 183, 10, 1, NULL, NULL),
(961, '00:00', '00:00', '0', NULL, NULL, 184, 1, 1, NULL, NULL),
(962, '00:00', '00:00', '0', NULL, NULL, 184, 2, 1, NULL, NULL),
(963, '00:00', '00:00', '0', NULL, NULL, 184, 3, 1, NULL, NULL),
(964, '00:00', '00:00', '0', NULL, NULL, 184, 4, 1, NULL, NULL),
(965, '00:00', '00:00', '0', NULL, NULL, 184, 5, 1, NULL, NULL),
(966, '00:00', '00:00', '0', NULL, NULL, 184, 7, 1, NULL, NULL),
(967, '00:00', '00:00', '0', NULL, NULL, 184, 8, 1, NULL, NULL),
(968, '00:00', '00:00', '0', NULL, NULL, 184, 10, 1, NULL, NULL),
(969, '00:00', '00:00', '0', NULL, NULL, 185, 1, 1, NULL, NULL),
(970, '00:00', '00:00', '0', NULL, NULL, 185, 3, 1, NULL, NULL),
(971, '00:00', '00:00', '0', NULL, NULL, 185, 4, 1, NULL, NULL),
(972, '00:00', '00:00', '0', NULL, NULL, 185, 5, 1, NULL, NULL),
(973, '00:00', '00:00', '0', NULL, NULL, 185, 6, 1, NULL, NULL),
(974, '00:00', '00:00', '0', NULL, NULL, 185, 7, 1, NULL, NULL),
(975, '00:00', '00:00', '0', NULL, NULL, 185, 8, 1, NULL, NULL),
(976, '00:00', '00:00', '0', NULL, NULL, 185, 10, 1, NULL, NULL),
(977, '00:00', '00:00', '0', NULL, NULL, 171, 2, 1, NULL, NULL),
(978, '00:00', '00:00', '0', NULL, NULL, 187, 1, 1, NULL, NULL),
(979, '00:00', '00:00', '0', NULL, NULL, 187, 3, 1, NULL, NULL),
(980, '00:00', '00:00', '0', NULL, NULL, 187, 4, 1, NULL, NULL),
(981, '00:00', '00:00', '0', NULL, NULL, 187, 5, 1, NULL, NULL),
(982, '00:00', '00:00', '0', NULL, NULL, 187, 7, 1, NULL, NULL),
(983, '00:00', '00:00', '0', NULL, NULL, 187, 8, 1, NULL, NULL),
(984, '00:00', '00:00', '0', NULL, NULL, 187, 9, 1, NULL, NULL),
(985, '00:00', '00:00', '0', NULL, NULL, 187, 10, 1, NULL, NULL),
(986, '00:00', '00:00', '0', NULL, NULL, 188, 1, 1, NULL, NULL),
(987, '00:00', '00:00', '0', NULL, NULL, 188, 4, 1, NULL, NULL),
(988, '00:00', '00:00', '0', NULL, NULL, 189, 1, 1, NULL, NULL),
(989, '00:00', '00:00', '0', NULL, NULL, 189, 4, 1, NULL, NULL),
(990, '00:00', '00:00', '0', NULL, NULL, 190, 1, 1, NULL, NULL),
(991, '00:00', '00:00', '0', NULL, NULL, 191, 1, 1, NULL, NULL),
(992, '00:00', '00:00', '0', NULL, NULL, 191, 2, 1, NULL, NULL),
(993, '00:00', '00:00', '0', NULL, NULL, 191, 3, 1, NULL, NULL),
(994, '00:00', '00:00', '0', NULL, NULL, 191, 4, 1, NULL, NULL),
(995, '00:00', '00:00', '0', NULL, NULL, 191, 5, 1, NULL, NULL),
(996, '00:00', '00:00', '0', NULL, NULL, 191, 7, 1, NULL, NULL),
(997, '00:00', '00:00', '0', NULL, NULL, 191, 8, 1, NULL, NULL),
(998, '00:00', '00:00', '0', NULL, NULL, 191, 10, 1, NULL, NULL),
(999, '00:00', '33:18', '0', '2017-11-17', NULL, 192, 1, 2, '11:01:27', '11:03:59'),
(1000, '00:00', '00:00', '0', NULL, NULL, 192, 2, 1, NULL, NULL),
(1001, '00:00', '00:00', '0', NULL, NULL, 192, 3, 1, NULL, NULL),
(1002, '00:00', '00:00', '0', NULL, NULL, 192, 4, 1, NULL, NULL),
(1003, '00:00', '00:00', '0', NULL, NULL, 192, 5, 1, NULL, NULL),
(1004, '00:00', '00:00', '0', NULL, NULL, 192, 7, 1, NULL, NULL),
(1005, '00:00', '00:00', '0', NULL, NULL, 192, 8, 1, NULL, NULL),
(1006, '00:00', '00:00', '0', NULL, NULL, 192, 10, 1, NULL, NULL),
(1007, '00:00', '00:00', '0', NULL, NULL, 191, 6, 1, NULL, NULL),
(1008, '00:00', '00:00', '0', NULL, NULL, 191, 9, 1, NULL, NULL),
(1009, '00:00', '04:05', '10', '2017-11-17', '2017-11-17', 195, 1, 3, '07:52:19', '07:56:24'),
(1010, '00:00', '12:59', '10', '2017-11-16', '2017-11-17', 195, 3, 3, '07:57:00', '08:02:26'),
(1011, '00:00', '03:57', '10', '2017-11-17', '2017-11-17', 195, 4, 3, '07:57:04', '08:01:01'),
(1012, '00:00', '03:50', '10', '2017-11-17', '2017-11-17', 195, 5, 3, '07:57:08', '08:00:58'),
(1013, '00:00', '03:36', '10', '2017-11-17', '2017-11-17', 195, 7, 3, '07:57:15', '08:00:51'),
(1014, '00:00', '05:54', '10', '2017-11-17', '2017-11-17', 195, 8, 3, '07:57:18', '08:03:12'),
(1015, '00:00', '03:07', '10', '2017-11-17', '2017-11-17', 195, 9, 3, '07:57:41', '08:00:48'),
(1016, '00:00', '00:00', '0', NULL, NULL, 195, 10, 1, NULL, NULL),
(1017, '00:00', '00:00', '0', NULL, NULL, 196, 1, 1, NULL, NULL),
(1018, '00:00', '00:00', '0', NULL, NULL, 196, 2, 1, NULL, NULL),
(1019, '00:00', '00:00', '0', NULL, NULL, 196, 3, 1, NULL, NULL),
(1020, '00:00', '00:00', '0', NULL, NULL, 196, 4, 1, NULL, NULL),
(1021, '00:00', '00:00', '0', NULL, NULL, 196, 5, 1, NULL, NULL),
(1022, '00:00', '00:00', '0', NULL, NULL, 196, 6, 1, NULL, NULL),
(1023, '00:00', '00:00', '0', NULL, NULL, 196, 7, 1, NULL, NULL),
(1024, '00:00', '00:00', '0', NULL, NULL, 196, 8, 1, NULL, NULL),
(1025, '00:00', '00:00', '0', NULL, NULL, 196, 9, 1, NULL, NULL),
(1026, '00:00', '00:00', '0', NULL, NULL, 196, 10, 1, NULL, NULL),
(1027, '00:00', '00:00', '0', NULL, NULL, 197, 1, 1, NULL, NULL),
(1028, '00:00', '00:00', '0', NULL, NULL, 197, 3, 1, NULL, NULL),
(1029, '00:00', '00:00', '0', NULL, NULL, 197, 4, 1, NULL, NULL),
(1030, '00:00', '00:00', '0', NULL, NULL, 197, 5, 1, NULL, NULL),
(1031, '00:00', '00:00', '0', NULL, NULL, 197, 7, 1, NULL, NULL),
(1032, '00:00', '00:00', '0', NULL, NULL, 197, 8, 1, NULL, NULL),
(1033, '00:00', '00:00', '0', NULL, NULL, 197, 9, 1, NULL, NULL),
(1034, '00:00', '00:00', '0', NULL, NULL, 197, 10, 1, NULL, NULL),
(1035, '00:00', '00:00', '0', NULL, NULL, 198, 1, 1, NULL, NULL),
(1036, '00:00', '00:00', '0', NULL, NULL, 198, 4, 1, NULL, NULL),
(1037, '00:00', '00:00', '0', NULL, NULL, 199, 1, 1, NULL, NULL),
(1038, '00:00', '00:00', '0', NULL, NULL, 199, 4, 1, NULL, NULL),
(1039, '00:00', '00:00', '0', NULL, NULL, 200, 1, 1, NULL, NULL),
(1040, '00:00', '00:00', '0', NULL, NULL, 201, 1, 1, NULL, NULL),
(1041, '00:00', '00:00', '0', NULL, NULL, 201, 2, 1, NULL, NULL),
(1042, '00:00', '00:00', '0', NULL, NULL, 201, 3, 1, NULL, NULL),
(1043, '00:00', '00:00', '0', NULL, NULL, 201, 4, 1, NULL, NULL),
(1044, '00:00', '00:00', '0', NULL, NULL, 201, 5, 1, NULL, NULL),
(1045, '00:00', '00:00', '0', NULL, NULL, 201, 6, 1, NULL, NULL),
(1046, '00:00', '00:00', '0', NULL, NULL, 201, 7, 1, NULL, NULL),
(1047, '00:00', '00:00', '0', NULL, NULL, 201, 8, 1, NULL, NULL),
(1048, '00:00', '00:00', '0', NULL, NULL, 201, 9, 1, NULL, NULL),
(1049, '00:00', '00:00', '0', NULL, NULL, 201, 10, 1, NULL, NULL),
(1050, '00:00', '00:00', '0', NULL, NULL, 202, 1, 1, NULL, NULL),
(1051, '00:00', '00:00', '0', NULL, NULL, 202, 2, 1, NULL, NULL),
(1052, '00:00', '00:00', '0', NULL, NULL, 202, 3, 1, NULL, NULL),
(1053, '00:00', '00:00', '0', NULL, NULL, 202, 4, 1, NULL, NULL),
(1054, '00:00', '00:00', '0', NULL, NULL, 202, 5, 1, NULL, NULL),
(1055, '00:00', '00:00', '0', NULL, NULL, 202, 6, 1, NULL, NULL),
(1056, '00:00', '00:00', '0', NULL, NULL, 202, 7, 1, NULL, NULL),
(1057, '00:00', '00:00', '0', NULL, NULL, 202, 8, 1, NULL, NULL),
(1058, '00:00', '00:00', '0', NULL, NULL, 202, 10, 1, NULL, NULL),
(1059, '00:00', '00:00', '0', NULL, NULL, 204, 1, 1, NULL, NULL),
(1060, '00:00', '00:00', '0', NULL, NULL, 204, 3, 1, NULL, NULL),
(1061, '00:00', '00:00', '0', NULL, NULL, 204, 4, 1, NULL, NULL),
(1062, '00:00', '00:00', '0', NULL, NULL, 204, 5, 1, NULL, NULL),
(1063, '00:00', '00:00', '0', NULL, NULL, 204, 6, 1, NULL, NULL),
(1064, '00:00', '00:00', '0', NULL, NULL, 204, 7, 1, NULL, NULL),
(1065, '00:00', '00:00', '0', NULL, NULL, 204, 8, 1, NULL, NULL),
(1066, '00:00', '00:00', '0', NULL, NULL, 204, 10, 1, NULL, NULL),
(1067, '00:00', '00:00', '0', NULL, NULL, 211, 1, 1, NULL, NULL),
(1068, '00:00', '00:00', '0', NULL, NULL, 211, 3, 1, NULL, NULL),
(1069, '00:00', '00:00', '0', NULL, NULL, 211, 4, 1, NULL, NULL),
(1070, '00:00', '00:00', '0', NULL, NULL, 211, 5, 1, NULL, NULL),
(1071, '00:00', '00:00', '0', NULL, NULL, 211, 6, 1, NULL, NULL),
(1072, '00:00', '00:00', '0', NULL, NULL, 211, 7, 1, NULL, NULL),
(1073, '00:00', '00:00', '0', NULL, NULL, 211, 8, 1, NULL, NULL),
(1074, '00:00', '00:00', '0', NULL, NULL, 211, 9, 1, NULL, NULL),
(1075, '00:00', '00:00', '0', NULL, NULL, 211, 10, 1, NULL, NULL),
(1076, '00:00', '00:00', '0', NULL, NULL, 217, 1, 1, NULL, NULL),
(1077, '00:00', '00:00', '0', NULL, NULL, 217, 3, 1, NULL, NULL),
(1078, '00:00', '00:00', '0', NULL, NULL, 217, 4, 1, NULL, NULL),
(1079, '00:00', '00:00', '0', NULL, NULL, 217, 5, 1, NULL, NULL),
(1080, '00:00', '00:00', '0', NULL, NULL, 217, 7, 1, NULL, NULL),
(1081, '00:00', '00:00', '0', NULL, NULL, 217, 8, 1, NULL, NULL),
(1082, '00:00', '00:00', '0', NULL, NULL, 217, 10, 1, NULL, NULL),
(1083, '00:00', '00:00', '0', NULL, NULL, 218, 1, 1, NULL, NULL),
(1084, '00:00', '00:00', '0', NULL, NULL, 218, 2, 1, NULL, NULL),
(1085, '00:00', '00:00', '0', NULL, NULL, 218, 3, 1, NULL, NULL),
(1086, '00:00', '00:00', '0', NULL, NULL, 218, 4, 1, NULL, NULL),
(1087, '00:00', '00:00', '0', NULL, NULL, 218, 5, 1, NULL, NULL),
(1088, '00:00', '00:00', '0', NULL, NULL, 218, 7, 1, NULL, NULL),
(1089, '00:00', '00:00', '0', NULL, NULL, 218, 8, 1, NULL, NULL),
(1090, '00:00', '00:00', '0', NULL, NULL, 218, 10, 1, NULL, NULL),
(1091, '00:00', '00:00', '0', NULL, NULL, 223, 1, 1, NULL, NULL),
(1092, '00:00', '00:00', '0', NULL, NULL, 223, 4, 1, NULL, NULL),
(1093, '00:00', '00:00', '0', NULL, NULL, 227, 1, 1, NULL, NULL),
(1094, '00:00', '00:00', '0', NULL, NULL, 227, 3, 1, NULL, NULL),
(1095, '00:00', '00:00', '0', NULL, NULL, 227, 4, 1, NULL, NULL),
(1096, '00:00', '00:00', '0', NULL, NULL, 227, 5, 1, NULL, NULL),
(1097, '00:00', '00:00', '0', NULL, NULL, 227, 7, 1, NULL, NULL),
(1098, '00:00', '00:00', '0', NULL, NULL, 227, 8, 1, NULL, NULL),
(1099, '00:00', '00:00', '0', NULL, NULL, 227, 10, 1, NULL, NULL),
(1100, '00:00', '53:33', '10', '2017-11-21', '2017-11-21', 235, 1, 3, '12:05:38', '12:59:11'),
(1101, '00:00', '03:37', '3', '2017-11-21', NULL, 235, 3, 2, '12:59:41', '13:03:18'),
(1102, '00:00', '00:00', '0', NULL, NULL, 235, 4, 1, NULL, NULL),
(1103, '00:00', '00:00', '0', NULL, NULL, 235, 5, 1, NULL, NULL),
(1104, '00:00', '00:00', '0', NULL, NULL, 235, 7, 1, NULL, NULL),
(1105, '00:00', '00:00', '0', NULL, NULL, 235, 8, 1, NULL, NULL),
(1106, '00:00', '00:00', '0', NULL, NULL, 235, 10, 1, NULL, NULL),
(1107, '00:00', '00:00', '0', NULL, NULL, 236, 1, 1, NULL, NULL),
(1108, '00:00', '00:00', '0', NULL, NULL, 236, 3, 1, NULL, NULL),
(1109, '00:00', '00:00', '0', NULL, NULL, 236, 4, 1, NULL, NULL),
(1110, '00:00', '00:00', '0', NULL, NULL, 236, 5, 1, NULL, NULL),
(1111, '00:00', '00:00', '0', NULL, NULL, 236, 7, 1, NULL, NULL),
(1112, '00:00', '00:00', '0', NULL, NULL, 236, 8, 1, NULL, NULL),
(1113, '00:00', '00:00', '0', NULL, NULL, 236, 9, 1, NULL, NULL),
(1114, '00:00', '00:00', '0', NULL, NULL, 236, 10, 1, NULL, NULL),
(1115, '00:00', '01:41', '0', '2017-11-21', NULL, 237, 1, 2, '16:14:36', '16:16:17'),
(1116, '00:00', '00:00', '0', NULL, NULL, 237, 4, 1, NULL, NULL),
(1117, '00:00', '02:33', '0', '2017-11-21', NULL, 238, 1, 2, '16:14:18', '16:16:51'),
(1118, '00:00', '00:00', '0', NULL, NULL, 238, 4, 1, NULL, NULL),
(1119, '00:00', '10:12', '0', '2017-11-21', NULL, 239, 1, 2, '16:14:06', '16:17:01');

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
  `pro_Terminado` tinyint(10) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_proyecto`
--

INSERT INTO `detalle_proyecto` (`idDetalle_proyecto`, `tipo_negocio_idtipo_negocio`, `canitadad_total`, `material`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`, `PNC`, `ubicacion`, `pro_porIniciar`, `pro_Ejecucion`, `pro_Pausado`, `pro_Terminado`) VALUES
(143, 1, '10', 'TH', 28921, 1, 1, 0, NULL, 10, 0, 0, 0),
(170, 1, '100', 'FV', 28542, 1, 1, 0, NULL, 7, 0, 0, 0),
(171, 7, '20', 'TH', 28542, 1, 1, 0, NULL, 8, 0, 0, 0),
(175, 5, '10', 'Lexan', 28531, 2, 3, 0, NULL, 0, 0, 0, 4),
(178, 3, '10', 'FV', 28543, 1, 1, 0, NULL, 2, 0, 0, 0),
(180, 2, '10', 'FV', 28543, 1, 1, 0, NULL, 8, 0, 0, 0),
(181, 1, '10', 'TH', 28532, 1, 1, 0, NULL, 10, 0, 0, 0),
(182, 1, '3', 'TH', 28533, 1, 1, 0, NULL, 10, 0, 0, 0),
(183, 1, '20', 'FV', 28534, 1, 1, 0, NULL, 8, 0, 0, 0),
(184, 1, '80', 'TH', 28535, 1, 1, 0, NULL, 8, 0, 0, 0),
(185, 1, '200', 'FV', 28536, 1, 1, 0, NULL, 8, 0, 0, 0),
(186, 1, '10', NULL, 28537, 3, 1, 0, NULL, 7, 0, 0, 0),
(187, 2, '10', 'FV', 28538, 1, 1, 0, NULL, 8, 0, 0, 0),
(188, 4, '1', 'FV', 28538, 1, 1, 0, NULL, 2, 0, 0, 0),
(189, 3, '5', 'FV', 28538, 1, 1, 0, NULL, 2, 0, 0, 0),
(190, 6, '1', '', 28538, 1, 1, 0, NULL, 1, 0, 0, 0),
(191, 1, '10', 'TH', 28538, 1, 1, 0, NULL, 8, 0, 0, 0),
(192, 7, '10', 'TH', 28538, 1, 2, 0, NULL, 7, 0, 1, 0),
(193, 5, '10', 'lexan', 28538, 2, 3, 0, NULL, 3, 0, 0, 1),
(194, 1, '10', '', 28538, 3, 1, 0, NULL, 0, 0, 0, 0),
(195, 1, '10', 'FV', 28539, 1, 2, 0, NULL, 1, 0, 0, 7),
(196, 1, '5', 'TH', 28540, 1, 1, 0, NULL, 10, 0, 0, 0),
(197, 2, '10', 'FV', 28541, 1, 1, 0, NULL, 8, 0, 0, 0),
(198, 4, '20', 'FV', 28541, 1, 1, 0, NULL, 2, 0, 0, 0),
(199, 3, '10', 'FV', 28541, 1, 1, 0, NULL, 2, 0, 0, 0),
(200, 6, '1', NULL, 28541, 1, 1, 0, NULL, 1, 0, 0, 0),
(201, 1, '1000', 'TH', 28541, 1, 1, 0, NULL, 10, 0, 0, 0),
(202, 7, '1000', 'TH', 28541, 1, 1, 0, NULL, 9, 0, 0, 0),
(203, 5, '100', 'Lexan', 28541, 2, 1, 0, NULL, 0, 0, 0, 0),
(204, 1, '16', 'FV', 28545, 1, 1, 0, NULL, 8, 0, 0, 0),
(206, 5, '10', 'Lexan', 28530, 2, 1, 0, NULL, 0, 0, 0, 0),
(211, 1, '2', NULL, 28533, 1, 1, 1, 'Perforado', 9, 0, 0, 0),
(217, 1, '1', 'FV', 28927, 1, 1, 0, NULL, 7, 0, 0, 0),
(218, 1, '10', 'TH', 28928, 1, 1, 0, NULL, 8, 0, 0, 0),
(220, 5, '10', 'Lexan', 28930, 2, 1, 0, NULL, 0, 0, 0, 0),
(222, 1, '10', NULL, 28932, 3, 1, 0, NULL, 0, 0, 0, 0),
(223, 3, '10', NULL, 28543, 1, 1, 1, 'Perforado', 2, 0, 0, 0),
(226, 5, '10', 'Lexan', 28933, 2, 1, 0, NULL, 0, 0, 0, 0),
(227, 1, '10', NULL, 28542, 1, 1, 1, 'Perforado', 7, 0, 0, 0),
(234, 5, '10', 'Lexan', 20000, 2, 3, 0, NULL, 3, 0, 0, 1),
(235, 1, '10', 'FV', 28934, 1, 2, 0, NULL, 5, 0, 1, 1),
(236, 2, '10', 'FV', 28935, 1, 1, 0, NULL, 8, 0, 0, 0),
(237, 4, '10', 'FV', 28935, 1, 2, 0, NULL, 1, 0, 1, 0),
(238, 3, '1', 'FV', 28935, 1, 2, 0, NULL, 1, 0, 1, 0),
(239, 6, '1', '', 28935, 1, 2, 0, NULL, 0, 0, 1, 0),
(240, 5, '80', 'Lexan', 28935, 2, 1, 0, NULL, 0, 0, 0, 0),
(241, 5, '125', 'Lexan', 28936, 2, 2, 0, NULL, 3, 0, 1, 0);

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
  `hora_terminacion` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_teclados`
--

INSERT INTO `detalle_teclados` (`idDetalle_teclados`, `tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`, `hora_ejecucion`, `hora_terminacion`) VALUES
(57, '00:00', '44:11', '10', '2017-11-16', '2017-11-21', 175, 11, 3, '16:21:30', '16:21:40'),
(58, '00:00', '01:03', '10', '2017-11-21', '2017-11-21', 175, 12, 3, '16:22:56', '16:23:59'),
(59, '00:00', '00:44', '10', '2017-11-21', '2017-11-21', 175, 13, 3, '16:34:54', '16:35:35'),
(60, '00:00', '00:21', '10', '2017-11-21', '2017-11-21', 175, 14, 3, '16:19:46', '16:20:07'),
(61, '00:00', '00:00', '0', NULL, NULL, 193, 11, 1, NULL, NULL),
(62, '00:00', '00:00', '0', NULL, NULL, 193, 12, 1, NULL, NULL),
(63, '00:00', '00:00', '0', NULL, NULL, 193, 13, 1, NULL, NULL),
(64, '00:00', '25:46', '10', '2017-11-17', '2017-11-17', 193, 14, 3, '16:30:17', '16:30:51'),
(65, '00:00', '00:00', '0', NULL, NULL, 203, 11, 1, NULL, NULL),
(66, '00:00', '00:00', '0', NULL, NULL, 203, 12, 1, NULL, NULL),
(67, '00:00', '00:00', '0', NULL, NULL, 203, 13, 1, NULL, NULL),
(68, '00:00', '00:00', '0', NULL, NULL, 203, 14, 1, NULL, NULL),
(69, '00:00', '00:00', '0', NULL, NULL, 206, 11, 1, NULL, NULL),
(70, '00:00', '00:00', '0', NULL, NULL, 206, 12, 1, NULL, NULL),
(71, '00:00', '00:00', '0', NULL, NULL, 206, 13, 1, NULL, NULL),
(72, '00:00', '00:00', '0', NULL, NULL, 206, 14, 1, NULL, NULL),
(73, '00:00', '00:00', '0', NULL, NULL, 220, 11, 1, NULL, NULL),
(74, '00:00', '00:00', '0', NULL, NULL, 220, 12, 1, NULL, NULL),
(75, '00:00', '00:00', '0', NULL, NULL, 220, 13, 1, NULL, NULL),
(76, '00:00', '00:00', '0', NULL, NULL, 220, 14, 1, NULL, NULL),
(85, '00:00', '00:00', '0', NULL, NULL, 226, 11, 1, NULL, NULL),
(86, '00:00', '00:00', '0', NULL, NULL, 226, 12, 1, NULL, NULL),
(87, '00:00', '00:00', '0', NULL, NULL, 226, 13, 1, NULL, NULL),
(88, '00:00', '00:00', '0', NULL, NULL, 226, 14, 1, NULL, NULL),
(89, '00:00', '00:00', '0', NULL, NULL, 234, 11, 1, NULL, NULL),
(90, '00:00', '00:00', '0', NULL, NULL, 234, 12, 1, NULL, NULL),
(91, '00:00', '00:00', '0', NULL, NULL, 234, 13, 1, NULL, NULL),
(92, '00:00', '01:04', '10', '2017-11-20', '2017-11-20', 234, 14, 3, '14:05:18', '14:06:22'),
(93, '00:00', '00:00', '0', NULL, NULL, 240, 11, 1, NULL, NULL),
(94, '00:00', '00:00', '0', NULL, NULL, 240, 12, 1, NULL, NULL),
(95, '00:00', '00:00', '0', NULL, NULL, 240, 13, 1, NULL, NULL),
(96, '00:00', '00:00', '0', NULL, NULL, 240, 14, 1, NULL, NULL),
(97, '00:00', '00:00', '0', NULL, NULL, 241, 11, 1, NULL, NULL),
(98, '00:00', '00:00', '0', NULL, NULL, 241, 12, 1, NULL, NULL),
(99, '00:00', '00:00', '0', NULL, NULL, 241, 13, 1, NULL, NULL),
(100, '00:00', '00:40', '0', '2017-11-21', NULL, 241, 14, 2, '16:41:55', '16:42:35');

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
  `nom_negocio` varchar(6) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `negocio`
--

INSERT INTO `negocio` (`idnegocio`, `nom_negocio`, `estado`) VALUES
(1, 'FE', 1),
(2, 'TE', 1),
(3, 'IN', 1);

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
(21, 'Arnes', 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `numero_orden` int(11) NOT NULL,
  `usuario_numero_documento` varchar(13) NOT NULL,
  `nombre_cliente` varchar(45) DEFAULT NULL,
  `nombre_proyecto` varchar(45) DEFAULT NULL,
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
  `ruteoP` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`numero_orden`, `usuario_numero_documento`, `nombre_cliente`, `nombre_proyecto`, `tipo_proyecto`, `FE`, `TE`, `IN`, `pcb_FE`, `pcb_TE`, `Conversor`, `Repujado`, `troquel`, `stencil`, `lexan`, `fecha_ingreso`, `fecha_entrega`, `fecha_salidal`, `ruteoC`, `antisolderC`, `estado_idestado`, `antisolderP`, `ruteoP`) VALUES
(20000, '98113053240', 'juan david marulanda', 'prueba de numero ', 'Normal', 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, '2017-11-10 08:17:23', '2017-11-11', '2017-11-20 16:04:02', 0, 0, 3, 0, 0),
(28530, '98113053240', 'juan david marulanda', 'prueba de estados', 'RQT', 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, '2017-11-15 11:55:08', '2017-11-16', NULL, 0, 0, 1, 0, 0),
(28531, '98113053240', 'juan david marulanda', 'prueba de estados', 'Quick', 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, '2017-11-15 13:27:34', '2017-11-15', '2017-11-21 16:35:36', 0, 0, 3, 0, 0),
(28532, '981130', 'juan david marulanda', 'demostración', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-16 07:49:59', '2017-11-17', NULL, 1, 1, 1, 0, 0),
(28533, '981130', 'juan esteban ramirez', 'demostración dos', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-16 08:02:53', '2017-11-17', NULL, 1, 1, 1, 0, 0),
(28534, '981130', 'anderson', 'demostración tres', 'RQT', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-16 08:07:12', '2017-11-29', NULL, 1, 0, 1, 0, 0),
(28535, '981130', 'jhon jairo sanchez', 'demostración cuatro', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-16 08:08:40', '2017-11-30', NULL, 0, 0, 1, 0, 0),
(28536, '981130', 'juan jhoan alexis', 'demostracion cinto', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-16 08:24:24', '2017-12-01', NULL, 0, 1, 1, 0, 0),
(28537, '981130', 'juan david', 'marulanda', 'RQT', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, '2017-11-16 11:19:08', '2017-11-17', NULL, 0, 0, 1, 0, 0),
(28538, '981130', 'juan david marulanda', 'prueba de desarrollo', 'Normal', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, '2017-11-16 11:42:18', '2017-11-17', NULL, 1, 1, 2, 0, 0),
(28539, '981130', 'juan camilo muñoz', 'muestra del proyecto', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-16 12:00:33', '2017-11-17', NULL, 1, 0, 2, 0, 0),
(28540, '981130', 'dometal', 'probando con dometal', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-16 12:01:12', '2017-11-17', NULL, 1, 1, 1, 0, 0),
(28541, '981130', 'andres patiño', 'jusgando como es', 'RQT', 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, '2017-11-16 12:04:48', '2017-11-24', NULL, 1, 1, 1, 1, 0),
(28542, '98113053240', 'juan david marulanda', 'segundos y minutos p', 'Normal', 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, '2017-11-01 09:09:27', '2017-11-30', NULL, 0, 0, 1, 0, 0),
(28543, '98113053240', 'juan david marulanda', 'prueba numero veite', 'RQT', 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, '2017-11-03 13:32:49', '2017-11-04', NULL, 0, 0, 1, 0, 0),
(28545, '981130', 'juan david marulanda', 'proyecto de prueba', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-16 13:24:11', '2017-11-17', NULL, 0, 1, 1, 0, 0),
(28921, '98113053240', 'juan david marulanda', 'prueba de validacion', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-10 11:25:24', '2017-11-13', NULL, 0, 1, 1, 0, 0),
(28927, '981130', 'alsjkdbnakljsbndansjd', 'prueba definitivitia', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-17 11:44:23', '2017-11-17', NULL, 0, 0, 1, 0, 0),
(28928, '981130', 'juan david marulanda', 'prueba numero dos', 'Normal', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-17 11:58:26', '2017-11-17', NULL, 0, 0, 1, 0, 0),
(28930, '981130', 'juan david marulanda', 'prueba nume cuatro', 'Normal', 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, '2017-11-17 12:00:07', '2017-11-17', NULL, 0, 0, 1, 0, 0),
(28932, '981130', 'juan david marulanda', 'prueba numero seis', 'RQT', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, '2017-11-17 12:01:31', '2017-11-17', NULL, 0, 0, 1, 0, 0),
(28933, '981130', 'juan david marulanda', 'pruebas y más pruebas', 'Normal', 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, '2017-11-17 15:33:28', '2017-11-23', NULL, 0, 0, 1, 0, 0),
(28934, '981130', 'juan david marulanda', 'demostración', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-11-21 11:56:25', '2017-11-22', NULL, 0, 0, 2, 0, 0),
(28935, '981130', 'juan camilo muñoz', 'prueba de cantidad', 'Normal', 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, '2017-11-21 13:36:58', '2017-11-22', NULL, 0, 0, 2, 0, 0),
(28936, '98113053240', 'juan david marulanda', 'prueba de teclados', 'RQT', 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, '2017-11-21 16:39:10', '2017-11-22', NULL, 0, 0, 2, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiempo_proyecto`
--

CREATE TABLE `tiempo_proyecto` (
  `idtiempo_proyecto` int(11) NOT NULL,
  `time_total_procesos_FE` int(11) DEFAULT NULL,
  `time_total_unidad_FE` int(11) DEFAULT NULL,
  `time_total_procesos_TE` int(11) DEFAULT NULL,
  `time_total_unidad_TE` int(11) DEFAULT NULL,
  `time_total_procesos_IN` int(11) DEFAULT NULL,
  `time_total_unidad_IN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(7, 'PCB');

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
  `sesion` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`numero_documento`, `tipo_documento`, `nombres`, `apellidos`, `cargo_idcargo`, `imagen`, `estado`, `contraeña`, `sesion`) VALUES
('109999999', 'CC', 'juan andresa', 'asdasd', 1, NULL, 1, '109999999', 0),
('1216727816', 'CC', 'juan david', 'marulanda p', 3, NULL, 1, '1216727816', 0),
('981130', 'CC', 'sivia hortensia', 'paniagua gomez', 4, NULL, 1, '981130', 0),
('98113053', 'CC', 'Catalina', ' rosario', 1, NULL, 1, '98113053', 0),
('98113053240', 'CC', 'juan david ', 'marulito', 1, NULL, 1, '98113053240', 0),
('9813053240', 'CC', 'sergio andresss', 'marulanda', 2, NULL, 1, '9813053240', 0),
('99120101605', 'CC', 'sadasd', 'juan andres', 1, NULL, 1, '99120101605', 0);

--
-- Índices para tablas volcadas
--

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
-- Indices de la tabla `tiempo_proyecto`
--
ALTER TABLE `tiempo_proyecto`
  ADD PRIMARY KEY (`idtiempo_proyecto`);

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
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idcargo` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `detalle_ensamble`
--
ALTER TABLE `detalle_ensamble`
  MODIFY `idDetalle_ensamble` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT de la tabla `detalle_formato_estandar`
--
ALTER TABLE `detalle_formato_estandar`
  MODIFY `idDetalle_formato_estandar` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1120;
--
-- AUTO_INCREMENT de la tabla `detalle_proyecto`
--
ALTER TABLE `detalle_proyecto`
  MODIFY `idDetalle_proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=242;
--
-- AUTO_INCREMENT de la tabla `detalle_teclados`
--
ALTER TABLE `detalle_teclados`
  MODIFY `idDetalle_teclados` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `idestado` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `negocio`
--
ALTER TABLE `negocio`
  MODIFY `idnegocio` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `procesos`
--
ALTER TABLE `procesos`
  MODIFY `idproceso` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `numero_orden` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28937;
--
-- AUTO_INCREMENT de la tabla `tipo_negocio`
--
ALTER TABLE `tipo_negocio`
  MODIFY `idtipo_negocio` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

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
