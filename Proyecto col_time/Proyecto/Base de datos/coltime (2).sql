-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-10-2017 a las 18:33:43
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarDetalleProyecto` (IN `orden` INT(11))  NO SQL
SELECT d.idDetalle_proyecto,n.nom_negocio,t.nombre,d.canitadad_total,e.nombre as estado, d.PNC,d.ubicacion,d.material FROM tipo_negocio t  JOIN detalle_proyecto d on t.idtipo_negocio=d.tipo_negocio_idtipo_negocio JOIN negocio n on d.negocio_idnegocio=n.idnegocio JOIN estado e on d.estado_idestado=e.idestado WHERE d.proyecto_numero_orden=orden$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarNumeroOrden` ()  NO SQL
SHOW TABLE STATUS like 'proyecto'$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ConsultarProyectosEntrega` (IN `orden` INT, IN `nombreC` VARCHAR(45), IN `nombreP` VARCHAR(45), IN `fecha` VARCHAR(10))  NO SQL
BEGIN

IF orden='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado;
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%');
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%');
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%');
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%');
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
              ELSE 
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_entrega,'%Y-%m-%d')=fecha;                                   
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
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado;
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%');
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%');
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%');
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%');
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
              ELSE
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_ingreso,'%Y-%m-%d')=fecha;                                   
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
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado;
ELSE
  IF orden!='' and nombreC='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%');
  ELSE 
    IF orden='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%');
    ELSE
      IF orden='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%');
       ELSE
         IF orden!='' and nombreC!='' and nombreP='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%');
	      ELSE
            IF orden='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
            ELSE
              IF orden!='' and nombreC='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
              ELSE
                IF orden!='' and nombreC!='' and nombreP!='' and fecha='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%');
                ELSE
                  IF orden='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;
				  ELSE
                    IF orden!='' and nombreC='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;
 					ELSE
                      IF orden='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;                     					  ELSE
					     IF orden='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;  
                          ELSE
                            IF orden!='' and nombreC!='' and nombreP='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;  
						     ELSE
                               IF orden!='' and nombreC='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_proyecto LIKE concat(nombreP,'%') AND p.numero_orden LIKE concat(orden,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;  
                               ELSE
                                 IF orden='' and nombreC!='' and nombreP!='' and fecha!='' THEN
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;
                                 ELSE
                                   IF orden!='' and nombreC!='' and nombreP!='' and fecha!='' THEN 
SELECT p.numero_orden,u.nombres,p.nombre_cliente,p.nombre_proyecto,DATE_FORMAT(p.fecha_ingreso,'%d-%M-%Y %h:%i %p') as     ingreso,p.fecha_entrega,DATE_FORMAT(p.fecha_salidal,'%d-%M-%Y %h:%i %p') as salida,e.nombre,p.tipo_proyecto,p.FE,p.TE,p.IN,p.ruteo,p.antisolder FROM usuario u JOIN proyecto p ON u.numero_documento=p.usuario_numero_documento LEFT JOIN estado e on p.estado_idestado=e.idestado WHERE p.numero_orden LIKE concat(orden,'%') AND p.nombre_cliente LIKE concat(nombreC,'%') AND p.nombre_proyecto LIKE concat(nombreP,'%') AND DATE_FORMAT(p.fecha_salidal,'%Y-%m-%d')=fecha;                                   
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_FechaServidor` ()  NO SQL
SELECT DATE_FORMAT(CURDATE(),'%d-%M-%Y')$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleEnsamble` (IN `proceso` TINYINT)  NO SQL
BEGIN
INSERT INTO `detalle_ensamble`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES ('0','0','0',(SELECT MAX(idDetalle_proyecto) FROM detalle_proyecto),proceso,1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleFormatoEstandar` (IN `proceso` INT)  NO SQL
INSERT INTO `detalle_formato_estandar`(`tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
('0','0','0',(SELECT MAX(idDetalle_proyecto) FROM detalle_proyecto),proceso,1)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_RegistrarDetalleTeclados` (IN `proceso` INT)  NO SQL
BEGIN
INSERT INTO `detalle_teclados`(`tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`)VALUES
('0','0','0',(SELECT MAX(idDetalle_proyecto) FROM detalle_proyecto),proceso,1);
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

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_ModificarDetalleProyecto` (`orden` INT(11), `idDetalle` INT, `cantidad` VARCHAR(6), `material` VARCHAR(6)) RETURNS TINYINT(1) NO SQL
BEGIN
UPDATE `detalle_proyecto` SET `canitadad_total`=cantidad,`material`=material WHERE idDetalle_proyecto=idDetalle and proyecto_numero_orden=orden;
RETURN 1;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_RegistrarDetalleProyecto` (`orden` INT(11), `tipoNegocio` VARCHAR(20), `cantidad` VARCHAR(6), `negocio` VARCHAR(20), `estado` TINYINT(1), `material` VARCHAR(6)) RETURNS TINYINT(1) NO SQL
BEGIN
IF material != '' THEN
INSERT INTO `detalle_proyecto`(`tipo_negocio_idtipo_negocio`, `canitadad_total`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`,`material`) VALUES ((SELECT idtipo_negocio from tipo_negocio where nombre =tipoNegocio),cantidad,orden,(SELECT idnegocio FROM negocio WHERE nom_negocio =negocio),estado,material);
RETURN 1;
ELSE
INSERT INTO `detalle_proyecto`(`tipo_negocio_idtipo_negocio`, `canitadad_total`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`) VALUES ((SELECT idtipo_negocio from tipo_negocio where nombre =tipoNegocio),cantidad,orden,(SELECT idnegocio FROM negocio WHERE nom_negocio =negocio),estado);
RETURN 1;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `FU_RegistrarModificarProyecto` (`doc` VARCHAR(13), `cliente` VARCHAR(30), `proyecto` VARCHAR(30), `tipo` VARCHAR(6), `fe` TINYINT(1), `te` TINYINT(1), `inte` TINYINT(1), `pcbfe` TINYINT(1), `pcbte` TINYINT(1), `conv` TINYINT(1), `rep` TINYINT(1), `tro` TINYINT(1), `st` TINYINT(1), `lexan` TINYINT(1), `entrega` VARCHAR(10), `ruteo` TINYINT(1), `anti` TINYINT(1), `norden` INT, `op` TINYINT(1)) RETURNS TINYINT(11) NO SQL
IF op=1 THEN
INSERT INTO `proyecto`(`usuario_numero_documento`, `nombre_cliente`, `nombre_proyecto`, `tipo_proyecto`, `FE`, `TE`, `IN`, `pcb_FE`, `pcb_TE`, `Conversor`, `Repujado`, `troquel`, `stencil`, `lexan`, `fecha_ingreso`, `fecha_entrega`, `ruteo`, `antisolder`, `estado_idestado`) VALUES (doc,cliente,proyecto,tipo,fe,te,inte,pcbfe,pcbte,conv,rep,tro,st,lexan,(SELECT now()),entrega,ruteo,anti,1);
RETURN 1;
ELSE 
 UPDATE `proyecto` SET `nombre_cliente`=cliente,`nombre_proyecto`=proyecto,`tipo_proyecto`=tipo,`FE`=fe,`TE`=te,`IN`=inte,`pcb_FE`=pcbfe,`pcb_TE`=pcbte,`Conversor`=conv,`Repujado`=rep,`troquel`=tro,`stencil`=st,`lexan`=lexan,`fecha_entrega`=entrega,`ruteo`=ruteo,`antisolder`=anti WHERE numero_orden=norden;
RETURN 1;
END IF$$

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
  `tiempo_total_por_proceso` varchar(6) DEFAULT NULL,
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_ensamble`
--

INSERT INTO `detalle_ensamble` (`idDetalle_ensamble`, `tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
(20, '0', '0', '0', NULL, NULL, 31, 15, 1),
(21, '0', '0', '0', NULL, NULL, 31, 16, 1),
(22, '0', '0', '0', NULL, NULL, 31, 17, 1),
(23, '0', '0', '0', NULL, NULL, 31, 18, 1),
(24, '0', '0', '0', NULL, NULL, 31, 19, 1),
(25, '0', '0', '0', NULL, NULL, 31, 20, 1),
(26, '0', '0', '0', NULL, NULL, 32, 15, 1),
(27, '0', '0', '0', NULL, NULL, 32, 16, 1),
(28, '0', '0', '0', NULL, NULL, 32, 17, 1),
(29, '0', '0', '0', NULL, NULL, 32, 18, 1),
(30, '0', '0', '0', NULL, NULL, 32, 19, 1),
(31, '0', '0', '0', NULL, NULL, 32, 20, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_formato_estandar`
--

CREATE TABLE `detalle_formato_estandar` (
  `idDetalle_formato_estandar` smallint(6) NOT NULL,
  `tiempo_por_unidad` varchar(6) DEFAULT NULL,
  `tiempo_total_por_proceso` varchar(6) DEFAULT NULL,
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_formato_estandar`
--

INSERT INTO `detalle_formato_estandar` (`idDetalle_formato_estandar`, `tiempo_por_unidad`, `tiempo_total_por_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
(61, '0', '0', '0', NULL, NULL, 24, 1, 1),
(62, '0', '0', '0', NULL, NULL, 24, 2, 1),
(63, '0', '0', '0', NULL, NULL, 24, 3, 1),
(64, '0', '0', '0', NULL, NULL, 24, 4, 1),
(65, '0', '0', '0', NULL, NULL, 24, 5, 1),
(66, '0', '0', '0', NULL, NULL, 24, 6, 1),
(67, '0', '0', '0', NULL, NULL, 24, 7, 1),
(68, '0', '0', '0', NULL, NULL, 24, 8, 1),
(69, '0', '0', '0', NULL, NULL, 24, 9, 1),
(70, '0', '0', '0', NULL, NULL, 24, 10, 1),
(71, '0', '0', '0', NULL, NULL, 25, 1, 1),
(72, '0', '0', '0', NULL, NULL, 25, 2, 1),
(73, '0', '0', '0', NULL, NULL, 25, 3, 1),
(74, '0', '0', '0', NULL, NULL, 25, 4, 1),
(75, '0', '0', '0', NULL, NULL, 25, 5, 1),
(76, '0', '0', '0', NULL, NULL, 25, 6, 1),
(77, '0', '0', '0', NULL, NULL, 25, 7, 1),
(78, '0', '0', '0', NULL, NULL, 25, 8, 1),
(79, '0', '0', '0', NULL, NULL, 25, 9, 1),
(80, '0', '0', '0', NULL, NULL, 25, 10, 1),
(81, '0', '0', '0', NULL, NULL, 26, 1, 1),
(82, '0', '0', '0', NULL, NULL, 26, 2, 1),
(83, '0', '0', '0', NULL, NULL, 26, 3, 1),
(84, '0', '0', '0', NULL, NULL, 26, 4, 1),
(85, '0', '0', '0', NULL, NULL, 26, 5, 1),
(86, '0', '0', '0', NULL, NULL, 26, 6, 1),
(87, '0', '0', '0', NULL, NULL, 26, 7, 1),
(88, '0', '0', '0', NULL, NULL, 26, 8, 1),
(89, '0', '0', '0', NULL, NULL, 26, 9, 1),
(90, '0', '0', '0', NULL, NULL, 26, 10, 1),
(91, '0', '0', '0', NULL, NULL, 27, 1, 1),
(92, '0', '0', '0', NULL, NULL, 27, 2, 1),
(93, '0', '0', '0', NULL, NULL, 27, 3, 1),
(94, '0', '0', '0', NULL, NULL, 27, 4, 1),
(95, '0', '0', '0', NULL, NULL, 27, 5, 1),
(96, '0', '0', '0', NULL, NULL, 27, 6, 1),
(97, '0', '0', '0', NULL, NULL, 27, 7, 1),
(98, '0', '0', '0', NULL, NULL, 27, 8, 1),
(99, '0', '0', '0', NULL, NULL, 27, 9, 1),
(100, '0', '0', '0', NULL, NULL, 27, 10, 1),
(101, '0', '0', '0', NULL, NULL, 28, 1, 1),
(102, '0', '0', '0', NULL, NULL, 28, 2, 1),
(103, '0', '0', '0', NULL, NULL, 28, 3, 1),
(104, '0', '0', '0', NULL, NULL, 28, 4, 1),
(105, '0', '0', '0', NULL, NULL, 28, 5, 1),
(106, '0', '0', '0', NULL, NULL, 28, 6, 1),
(107, '0', '0', '0', NULL, NULL, 28, 7, 1),
(108, '0', '0', '0', NULL, NULL, 28, 8, 1),
(109, '0', '0', '0', NULL, NULL, 28, 9, 1),
(110, '0', '0', '0', NULL, NULL, 28, 10, 1),
(111, '0', '0', '0', NULL, NULL, 29, 1, 1),
(112, '0', '0', '0', NULL, NULL, 29, 2, 1),
(113, '0', '0', '0', NULL, NULL, 29, 3, 1),
(114, '0', '0', '0', NULL, NULL, 29, 4, 1),
(115, '0', '0', '0', NULL, NULL, 29, 5, 1),
(116, '0', '0', '0', NULL, NULL, 29, 6, 1),
(117, '0', '0', '0', NULL, NULL, 29, 7, 1),
(118, '0', '0', '0', NULL, NULL, 29, 8, 1),
(119, '0', '0', '0', NULL, NULL, 29, 9, 1),
(120, '0', '0', '0', NULL, NULL, 29, 10, 1),
(121, '0', '0', '0', NULL, NULL, 33, 1, 1),
(122, '0', '0', '0', NULL, NULL, 33, 2, 1),
(123, '0', '0', '0', NULL, NULL, 33, 3, 1),
(124, '0', '0', '0', NULL, NULL, 33, 4, 1),
(125, '0', '0', '0', NULL, NULL, 33, 5, 1),
(126, '0', '0', '0', NULL, NULL, 33, 6, 1),
(127, '0', '0', '0', NULL, NULL, 33, 7, 1),
(128, '0', '0', '0', NULL, NULL, 33, 8, 1),
(129, '0', '0', '0', NULL, NULL, 33, 9, 1),
(130, '0', '0', '0', NULL, NULL, 33, 10, 1),
(141, '0', '0', '0', NULL, NULL, 36, 1, 1),
(142, '0', '0', '0', NULL, NULL, 36, 2, 1),
(143, '0', '0', '0', NULL, NULL, 36, 3, 1),
(144, '0', '0', '0', NULL, NULL, 36, 4, 1),
(145, '0', '0', '0', NULL, NULL, 36, 5, 1),
(146, '0', '0', '0', NULL, NULL, 36, 6, 1),
(147, '0', '0', '0', NULL, NULL, 36, 7, 1),
(148, '0', '0', '0', NULL, NULL, 36, 8, 1),
(149, '0', '0', '0', NULL, NULL, 36, 9, 1),
(150, '0', '0', '0', NULL, NULL, 36, 10, 1),
(151, '0', '0', '0', NULL, NULL, 37, 1, 1),
(152, '0', '0', '0', NULL, NULL, 37, 2, 1),
(153, '0', '0', '0', NULL, NULL, 37, 3, 1),
(154, '0', '0', '0', NULL, NULL, 37, 4, 1),
(155, '0', '0', '0', NULL, NULL, 37, 5, 1),
(156, '0', '0', '0', NULL, NULL, 37, 6, 1),
(157, '0', '0', '0', NULL, NULL, 37, 7, 1),
(158, '0', '0', '0', NULL, NULL, 37, 8, 1),
(159, '0', '0', '0', NULL, NULL, 37, 9, 1),
(160, '0', '0', '0', NULL, NULL, 37, 10, 1),
(171, '0', '0', '0', NULL, NULL, 41, 1, 1),
(172, '0', '0', '0', NULL, NULL, 41, 2, 1),
(173, '0', '0', '0', NULL, NULL, 41, 3, 1),
(174, '0', '0', '0', NULL, NULL, 41, 4, 1),
(175, '0', '0', '0', NULL, NULL, 41, 5, 1),
(176, '0', '0', '0', NULL, NULL, 41, 6, 1),
(177, '0', '0', '0', NULL, NULL, 41, 7, 1),
(178, '0', '0', '0', NULL, NULL, 41, 8, 1),
(179, '0', '0', '0', NULL, NULL, 41, 9, 1),
(180, '0', '0', '0', NULL, NULL, 41, 10, 1),
(181, '0', '0', '0', NULL, NULL, 42, 1, 1),
(182, '0', '0', '0', NULL, NULL, 42, 2, 1),
(183, '0', '0', '0', NULL, NULL, 42, 3, 1),
(184, '0', '0', '0', NULL, NULL, 42, 4, 1),
(185, '0', '0', '0', NULL, NULL, 42, 5, 1),
(186, '0', '0', '0', NULL, NULL, 42, 6, 1),
(187, '0', '0', '0', NULL, NULL, 42, 7, 1),
(188, '0', '0', '0', NULL, NULL, 42, 8, 1),
(189, '0', '0', '0', NULL, NULL, 42, 9, 1),
(190, '0', '0', '0', NULL, NULL, 42, 10, 1),
(191, '0', '0', '0', NULL, NULL, 43, 1, 1),
(192, '0', '0', '0', NULL, NULL, 43, 2, 1),
(193, '0', '0', '0', NULL, NULL, 43, 3, 1),
(194, '0', '0', '0', NULL, NULL, 43, 4, 1),
(195, '0', '0', '0', NULL, NULL, 43, 5, 1),
(196, '0', '0', '0', NULL, NULL, 43, 6, 1),
(197, '0', '0', '0', NULL, NULL, 43, 7, 1),
(198, '0', '0', '0', NULL, NULL, 43, 8, 1),
(199, '0', '0', '0', NULL, NULL, 43, 9, 1),
(200, '0', '0', '0', NULL, NULL, 43, 10, 1);

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
  `ubicacion` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_proyecto`
--

INSERT INTO `detalle_proyecto` (`idDetalle_proyecto`, `tipo_negocio_idtipo_negocio`, `canitadad_total`, `material`, `proyecto_numero_orden`, `negocio_idnegocio`, `estado_idestado`, `PNC`, `ubicacion`) VALUES
(24, 2, '100', 'FV', 28520, 1, 1, 0, NULL),
(25, 4, '100', 'FV', 28520, 1, 1, 0, NULL),
(26, 3, '100', 'FV', 28520, 1, 1, 0, NULL),
(27, 6, '2', '', 28520, 1, 1, 0, NULL),
(28, 1, '100', 'FV', 28520, 1, 1, 0, NULL),
(29, 7, '100', 'FV', 28520, 1, 1, 0, NULL),
(30, 5, '100', 'lexan', 28520, 2, 1, 0, NULL),
(31, 1, '100', '', 28520, 3, 1, 0, NULL),
(32, 1, '20', NULL, 28521, 3, 1, 0, NULL),
(33, 1, '2', 'TH', 28522, 1, 1, 0, NULL),
(34, 2, '2', 'FV', 28520, 1, 1, 1, 'Quimicos'),
(35, 1, '10', 'TH', 28523, 1, 1, 0, NULL),
(36, 2, '100', 'FV', 28524, 1, 1, 0, NULL),
(37, 3, '2', 'FV', 28524, 1, 1, 0, NULL),
(41, 4, '1', 'FV', 28524, 1, 1, 0, NULL),
(42, 6, '1', '', 28524, 1, 1, 0, NULL),
(43, 1, '100', 'TH', 28524, 1, 1, 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_teclados`
--

CREATE TABLE `detalle_teclados` (
  `idDetalle_teclados` smallint(6) NOT NULL,
  `tiempo_por_unidad` varchar(6) DEFAULT NULL,
  `tiempo_total_proceso` varchar(6) DEFAULT NULL,
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_teclados`
--

INSERT INTO `detalle_teclados` (`idDetalle_teclados`, `tiempo_por_unidad`, `tiempo_total_proceso`, `cantidad_terminada`, `fecha_inicio`, `fecha_fin`, `detalle_proyecto_idDetalle_proyecto`, `Procesos_idproceso`, `estado_idestado`) VALUES
(9, '0', '0', '0', NULL, NULL, 30, 11, 1),
(10, '0', '0', '0', NULL, NULL, 30, 12, 1),
(11, '0', '0', '0', NULL, NULL, 30, 13, 1),
(12, '0', '0', '0', NULL, NULL, 30, 14, 1);

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
(20, 'Linea', 1, 3);

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
  `ruteo` tinyint(1) DEFAULT NULL,
  `antisolder` tinyint(1) DEFAULT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`numero_orden`, `usuario_numero_documento`, `nombre_cliente`, `nombre_proyecto`, `tipo_proyecto`, `FE`, `TE`, `IN`, `pcb_FE`, `pcb_TE`, `Conversor`, `Repujado`, `troquel`, `stencil`, `lexan`, `fecha_ingreso`, `fecha_entrega`, `fecha_salidal`, `ruteo`, `antisolder`, `estado_idestado`) VALUES
(28520, '98113053240', 'juan david marulanda', 'rude', 'Normal', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, '2017-10-04 11:04:25', '2017-11-30', NULL, 1, 1, 1),
(28521, '98113053240', 'el viejo ', 'roller foreverl life', 'RQT', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, '2017-10-06 08:13:27', '2017-10-14', NULL, 0, 0, 1),
(28522, '98113053240', 'gato', 'el gato', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-10-06 09:22:41', '2017-10-07', NULL, 0, 0, 1),
(28523, '98113053240', 'anderson', 'i\'am into you', 'Quick', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, '2017-10-09 23:10:10', '2017-10-13', NULL, 0, 1, 1),
(28524, '98113053240', 'camilo rios', 'el tecnoparque nodo medellin', 'Quick', 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, '2017-10-10 19:55:03', '2017-10-11', NULL, 1, 0, 1);

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
  `contraeña` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`numero_documento`, `tipo_documento`, `nombres`, `apellidos`, `cargo_idcargo`, `imagen`, `estado`, `contraeña`) VALUES
('109999999', 'CC', 'juan andres', 'asdasd', 1, NULL, 1, '109999999'),
('1216727816', 'CC', 'juan david', 'marulanda p', 1, NULL, 1, '1216727816'),
('981130', 'CC', 'sivia hortensia', 'paniagua gomez', 4, NULL, 1, '981130'),
('98113053', 'CC', 'Catalina', ' rosario', 1, NULL, 1, '98113053'),
('98113053240', 'CC', 'juan david ', 'marulito', 1, NULL, 1, '98113053240juan'),
('9813053240', 'CC', 'sergio andresss', 'marulanda', 2, NULL, 1, '9813053240'),
('99120101605', 'CC', 'sadasd', 'dasdas', 1, NULL, 1, '99120101605');

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
  MODIFY `idDetalle_ensamble` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `detalle_formato_estandar`
--
ALTER TABLE `detalle_formato_estandar`
  MODIFY `idDetalle_formato_estandar` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- AUTO_INCREMENT de la tabla `detalle_proyecto`
--
ALTER TABLE `detalle_proyecto`
  MODIFY `idDetalle_proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `detalle_teclados`
--
ALTER TABLE `detalle_teclados`
  MODIFY `idDetalle_teclados` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

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
  MODIFY `idproceso` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `numero_orden` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28525;

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
