-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-09-2017 a las 23:02:57
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `correotalento` (IN `_numero` VARCHAR(13))  NO SQL
SELECT numero_documento FROM usuario WHERE EXISTS (SELECT * FROM usuario where numero_documento=_numero)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ValidarUsuario` (IN `_doc` VARCHAR(13))  NO SQL
SELECT numero_documento FROM usuario where numero_documento=_doc$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `FU_InsertarModificarUsuar` (`_doc` VARCHAR(13), `_tipo` VARCHAR(3), `_nombre` VARCHAR(30), `_apellido` VARCHAR(30), `_cargo` INT, `_estado` BOOLEAN, `op` INT(1)) RETURNS TINYINT(1) NO SQL
IF op=1 THEN
INSERT INTO        usuario(numero_documento,tipo_documento,nombres,apellidos,cargo_idcargo,estado,contraeña)   VALUES (_doc,_tipo,_nombre,_apellido,_cargo,_estado,_doc);
RETURN 1;
 ELSEIF op =2 THEN
UPDATE usuario SET tipo_documento=_tipo,nombres=_nombre, apellidos=_apellido, cargo_idcargo=_cargo,estado=_estado where  numero_documento=_doc;
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
  `cantidad_procesando` varchar(6) DEFAULT NULL,
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_formato_estandar`
--

CREATE TABLE `detalle_formato_estandar` (
  `idDetalle_formato_estandar` smallint(6) NOT NULL,
  `proceso` varchar(25) NOT NULL,
  `tiempo_por_unidad` varchar(6) DEFAULT NULL,
  `tiempo_total_por_proceso` varchar(6) DEFAULT NULL,
  `cantidad_procesando` varchar(6) DEFAULT NULL,
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_proyecto`
--

CREATE TABLE `detalle_proyecto` (
  `idDetalle_proyecto` int(11) NOT NULL,
  `tipo_negocio_idtipo_negocio` tinyint(4) NOT NULL,
  `canitadad_total` varchar(6) NOT NULL,
  `proyecto_numero_orden` varchar(6) NOT NULL,
  `negocio_idnegocio` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_teclados`
--

CREATE TABLE `detalle_teclados` (
  `idDetalle_teclados` smallint(6) NOT NULL,
  `tiempo_por_unidad` varchar(6) DEFAULT NULL,
  `tiempo_total_proceso` varchar(6) DEFAULT NULL,
  `cantidad_terminada` varchar(6) DEFAULT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `detalle_proyecto_idDetalle_proyecto` int(11) NOT NULL,
  `Procesos_idproceso` tinyint(4) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `idestado` tinyint(4) NOT NULL,
  `nombre` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `negocio`
--

CREATE TABLE `negocio` (
  `idnegocio` tinyint(4) NOT NULL,
  `nom_negocio` varchar(6) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesos`
--

CREATE TABLE `procesos` (
  `idproceso` tinyint(4) NOT NULL,
  `nombre_proceso` varchar(25) NOT NULL,
  `estado` bit(1) NOT NULL,
  `negocio_idnegocio` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `numero_orden` varchar(6) NOT NULL,
  `usuario_numero_documento` varchar(13) NOT NULL,
  `nombre_cliente` varchar(30) DEFAULT NULL,
  `nombre_proyecto` varchar(30) DEFAULT NULL,
  `tipo_proyecto` varchar(6) DEFAULT NULL,
  `FE` bit(1) NOT NULL,
  `TE` bit(1) NOT NULL,
  `IN` bit(1) NOT NULL,
  `pcb_FE` bit(1) NOT NULL,
  `pcb_TE` bit(1) NOT NULL,
  `Conversor` bit(1) NOT NULL,
  `Repujado` bit(1) NOT NULL,
  `troquel` bit(1) NOT NULL,
  `stencil` bit(1) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `fecha_salidal` datetime DEFAULT NULL,
  `ruteo` bit(1) DEFAULT NULL,
  `antisolder` bit(1) DEFAULT NULL,
  `PNC` bit(1) NOT NULL,
  `estado_idestado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `estado` tinyint(1) DEFAULT NULL,
  `contraeña` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`numero_documento`, `tipo_documento`, `nombres`, `apellidos`, `cargo_idcargo`, `imagen`, `estado`, `contraeña`) VALUES
('1216727816', 'cc', 'juan david', 'marulanda p ', 1, NULL, 1, '1216727816'),
('981130', 'CC', 'sivia hortensia', 'paniagua gomez', 1, NULL, 1, '981130'),
('98113053', 'CC', 'Catalina', ' rosario', 1, NULL, 1, '98113053'),
('9813053240', 'cc', 'sergio andres', 'marulanda', 2, NULL, 1, '9813053240');

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
  MODIFY `idDetalle_ensamble` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_formato_estandar`
--
ALTER TABLE `detalle_formato_estandar`
  MODIFY `idDetalle_formato_estandar` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_proyecto`
--
ALTER TABLE `detalle_proyecto`
  MODIFY `idDetalle_proyecto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_teclados`
--
ALTER TABLE `detalle_teclados`
  MODIFY `idDetalle_teclados` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `negocio`
--
ALTER TABLE `negocio`
  MODIFY `idnegocio` tinyint(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `procesos`
--
ALTER TABLE `procesos`
  MODIFY `idproceso` tinyint(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_negocio`
--
ALTER TABLE `tipo_negocio`
  MODIFY `idtipo_negocio` tinyint(4) NOT NULL AUTO_INCREMENT;

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
