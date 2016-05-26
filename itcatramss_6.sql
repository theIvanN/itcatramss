SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `itcatramss_6` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `itcatramss_6` ;

-- -----------------------------------------------------
-- Table `itcatramss_6`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`usuario` (
  `idusuario` VARCHAR(10) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido1` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`estado` (
  `idestado` CHAR(3) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idestado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`sucursal` (
  `idsucursal` VARCHAR(10) NOT NULL,
  `direccion` VARCHAR(200) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idsucursal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`usuario_tiene_sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`usuario_tiene_sucursal` (
  `usuario_idusuario` VARCHAR(10) NOT NULL,
  `sucursal_idsucursal` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `sucursal_idsucursal`),
  INDEX `fk_usuario_has_sucursal_sucursal1_idx` (`sucursal_idsucursal` ASC),
  INDEX `fk_usuario_has_sucursal_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_usuario_has_sucursal_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `itcatramss_6`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_sucursal_sucursal1`
    FOREIGN KEY (`sucursal_idsucursal`)
    REFERENCES `itcatramss_6`.`sucursal` (`idsucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`rol` (
  `idrol` CHAR(3) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`auditoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`auditoria` (
  `idauditoria` VARCHAR(10) NOT NULL,
  `fecha` TIMESTAMP NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idauditoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`usuario_y_auditoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`usuario_y_auditoria` (
  `auditoria_idauditoria` VARCHAR(10) NOT NULL,
  `usuario_idusuario` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`auditoria_idauditoria`, `usuario_idusuario`),
  INDEX `fk_auditoria_has_usuario_usuario1_idx` (`usuario_idusuario` ASC),
  INDEX `fk_auditoria_has_usuario_auditoria1_idx` (`auditoria_idauditoria` ASC),
  CONSTRAINT `fk_auditoria_has_usuario_auditoria1`
    FOREIGN KEY (`auditoria_idauditoria`)
    REFERENCES `itcatramss_6`.`auditoria` (`idauditoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_auditoria_has_usuario_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `itcatramss_6`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`intento_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`intento_login` (
  `idintento_login` VARCHAR(10) NOT NULL,
  `intento_fecha` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idintento_login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`usuario_e_intento_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`usuario_e_intento_login` (
  `usuario_idusuario` VARCHAR(10) NOT NULL,
  `intento_login_idintento_login` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `intento_login_idintento_login`),
  INDEX `fk_usuario_has_intento_login_intento_login1_idx` (`intento_login_idintento_login` ASC),
  INDEX `fk_usuario_has_intento_login_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_usuario_has_intento_login_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `itcatramss_6`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_intento_login_intento_login1`
    FOREIGN KEY (`intento_login_idintento_login`)
    REFERENCES `itcatramss_6`.`intento_login` (`idintento_login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`chofer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`chofer` (
  `idchofer` VARCHAR(10) NOT NULL,
  `licencia` VARCHAR(45) NOT NULL,
  `pasaporte` VARCHAR(45) NULL,
  PRIMARY KEY (`idchofer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`usuario_y_chofer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`usuario_y_chofer` (
  `chofer_idchofer` VARCHAR(10) NOT NULL,
  `usuario_idusuario` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`chofer_idchofer`, `usuario_idusuario`),
  INDEX `fk_chofer_has_usuario_usuario1_idx` (`usuario_idusuario` ASC),
  INDEX `fk_chofer_has_usuario_chofer1_idx` (`chofer_idchofer` ASC),
  CONSTRAINT `fk_chofer_has_usuario_chofer1`
    FOREIGN KEY (`chofer_idchofer`)
    REFERENCES `itcatramss_6`.`chofer` (`idchofer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chofer_has_usuario_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `itcatramss_6`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vehiculo` (
  `idvehiculo` VARCHAR(10) NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `fecha_adquisicion` TIMESTAMP NOT NULL,
  `costo` DOUBLE NOT NULL,
  PRIMARY KEY (`idvehiculo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vehiculo_tiene_sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vehiculo_tiene_sucursal` (
  `vehiculo_idvehiculo` VARCHAR(10) NOT NULL,
  `sucursal_idsucursal` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vehiculo_idvehiculo`, `sucursal_idsucursal`),
  INDEX `fk_vehiculo_has_sucursal_sucursal1_idx` (`sucursal_idsucursal` ASC),
  INDEX `fk_vehiculo_has_sucursal_vehiculo1_idx` (`vehiculo_idvehiculo` ASC),
  CONSTRAINT `fk_vehiculo_has_sucursal_vehiculo1`
    FOREIGN KEY (`vehiculo_idvehiculo`)
    REFERENCES `itcatramss_6`.`vehiculo` (`idvehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehiculo_has_sucursal_sucursal1`
    FOREIGN KEY (`sucursal_idsucursal`)
    REFERENCES `itcatramss_6`.`sucursal` (`idsucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`reserva` (
  `idreserva` VARCHAR(10) NOT NULL,
  `fecha_reserva` DATETIME NOT NULL,
  `destino` VARCHAR(200) NULL,
  `nombre_evento` VARCHAR(45) NULL,
  PRIMARY KEY (`idreserva`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`reserva_tiene_vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`reserva_tiene_vehiculo` (
  `reserva_idreserva` VARCHAR(10) NOT NULL,
  `vehiculo_idvehiculo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`reserva_idreserva`, `vehiculo_idvehiculo`),
  INDEX `fk_reserva_has_vehiculo_vehiculo1_idx` (`vehiculo_idvehiculo` ASC),
  INDEX `fk_reserva_has_vehiculo_reserva1_idx` (`reserva_idreserva` ASC),
  CONSTRAINT `fk_reserva_has_vehiculo_reserva1`
    FOREIGN KEY (`reserva_idreserva`)
    REFERENCES `itcatramss_6`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_has_vehiculo_vehiculo1`
    FOREIGN KEY (`vehiculo_idvehiculo`)
    REFERENCES `itcatramss_6`.`vehiculo` (`idvehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`reserva_tiene_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`reserva_tiene_usuario` (
  `usuario_idusuario` VARCHAR(10) NOT NULL,
  `reserva_idreserva` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `reserva_idreserva`),
  INDEX `fk_usuario_has_reserva_reserva1_idx` (`reserva_idreserva` ASC),
  INDEX `fk_usuario_has_reserva_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_usuario_has_reserva_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `itcatramss_6`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_reserva_reserva1`
    FOREIGN KEY (`reserva_idreserva`)
    REFERENCES `itcatramss_6`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`color` (
  `idcolor` VARCHAR(10) NOT NULL,
  `nombre_color` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcolor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`marca` (
  `idmarca` VARCHAR(10) NOT NULL,
  `nombre_marca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`tipo` (
  `idtipo` VARCHAR(10) NOT NULL,
  `nombre_tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vehiculo_tiene_color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vehiculo_tiene_color` (
  `vehiculo_idvehiculo` VARCHAR(10) NOT NULL,
  `color_idcolor` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vehiculo_idvehiculo`, `color_idcolor`),
  INDEX `fk_vehiculo_has_color_color1_idx` (`color_idcolor` ASC),
  INDEX `fk_vehiculo_has_color_vehiculo1_idx` (`vehiculo_idvehiculo` ASC),
  CONSTRAINT `fk_vehiculo_has_color_vehiculo1`
    FOREIGN KEY (`vehiculo_idvehiculo`)
    REFERENCES `itcatramss_6`.`vehiculo` (`idvehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehiculo_has_color_color1`
    FOREIGN KEY (`color_idcolor`)
    REFERENCES `itcatramss_6`.`color` (`idcolor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vehiculo_tiene_marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vehiculo_tiene_marca` (
  `vehiculo_idvehiculo` VARCHAR(10) NOT NULL,
  `marca_idmarca` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vehiculo_idvehiculo`, `marca_idmarca`),
  INDEX `fk_vehiculo_has_marca_marca1_idx` (`marca_idmarca` ASC),
  INDEX `fk_vehiculo_has_marca_vehiculo1_idx` (`vehiculo_idvehiculo` ASC),
  CONSTRAINT `fk_vehiculo_has_marca_vehiculo1`
    FOREIGN KEY (`vehiculo_idvehiculo`)
    REFERENCES `itcatramss_6`.`vehiculo` (`idvehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehiculo_has_marca_marca1`
    FOREIGN KEY (`marca_idmarca`)
    REFERENCES `itcatramss_6`.`marca` (`idmarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vehiculo_tiene_tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vehiculo_tiene_tipo` (
  `vehiculo_idvehiculo` VARCHAR(10) NOT NULL,
  `tipo_idtipo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vehiculo_idvehiculo`, `tipo_idtipo`),
  INDEX `fk_vehiculo_has_tipo_tipo1_idx` (`tipo_idtipo` ASC),
  INDEX `fk_vehiculo_has_tipo_vehiculo1_idx` (`vehiculo_idvehiculo` ASC),
  CONSTRAINT `fk_vehiculo_has_tipo_vehiculo1`
    FOREIGN KEY (`vehiculo_idvehiculo`)
    REFERENCES `itcatramss_6`.`vehiculo` (`idvehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehiculo_has_tipo_tipo1`
    FOREIGN KEY (`tipo_idtipo`)
    REFERENCES `itcatramss_6`.`tipo` (`idtipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`mantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`mantenimiento` (
  `idmantenimiento` VARCHAR(10) NOT NULL,
  `nombre_taller` VARCHAR(45) NULL,
  `fecha_inicio` DATETIME NOT NULL,
  `fecha_entrega` DATETIME NOT NULL,
  `observacion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`idmantenimiento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vehiculo_tiene_mantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vehiculo_tiene_mantenimiento` (
  `vehiculo_idvehiculo` VARCHAR(10) NOT NULL,
  `mantenimiento_idmantenimiento` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vehiculo_idvehiculo`, `mantenimiento_idmantenimiento`),
  INDEX `fk_vehiculo_has_mantenimiento_mantenimiento1_idx` (`mantenimiento_idmantenimiento` ASC),
  INDEX `fk_vehiculo_has_mantenimiento_vehiculo1_idx` (`vehiculo_idvehiculo` ASC),
  CONSTRAINT `fk_vehiculo_has_mantenimiento_vehiculo1`
    FOREIGN KEY (`vehiculo_idvehiculo`)
    REFERENCES `itcatramss_6`.`vehiculo` (`idvehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehiculo_has_mantenimiento_mantenimiento1`
    FOREIGN KEY (`mantenimiento_idmantenimiento`)
    REFERENCES `itcatramss_6`.`mantenimiento` (`idmantenimiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`usuario_tiene_estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`usuario_tiene_estado` (
  `usuario_idusuario` VARCHAR(10) NOT NULL,
  `estado_idestado` CHAR(3) NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `estado_idestado`),
  INDEX `fk_usuario_has_estado_estado1_idx` (`estado_idestado` ASC),
  INDEX `fk_usuario_has_estado_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_usuario_has_estado_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `itcatramss_6`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_estado_estado1`
    FOREIGN KEY (`estado_idestado`)
    REFERENCES `itcatramss_6`.`estado` (`idestado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`usuario_tiene_rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`usuario_tiene_rol` (
  `usuario_idusuario` VARCHAR(10) NOT NULL,
  `rol_idrol` CHAR(3) NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `rol_idrol`),
  INDEX `fk_usuario_has_rol_rol1_idx` (`rol_idrol` ASC),
  INDEX `fk_usuario_has_rol_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_usuario_has_rol_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `itcatramss_6`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_rol_rol1`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `itcatramss_6`.`rol` (`idrol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vale_combustible`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vale_combustible` (
  `idvale_combustible` VARCHAR(10) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `fecha_emision` DATETIME NULL,
  PRIMARY KEY (`idvale_combustible`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vale_combustible_tiene_chofer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vale_combustible_tiene_chofer` (
  `vale_combustible_idvale_combustible` VARCHAR(10) NOT NULL,
  `chofer_idchofer` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vale_combustible_idvale_combustible`, `chofer_idchofer`),
  INDEX `fk_vale_combustible_has_chofer_chofer1_idx` (`chofer_idchofer` ASC),
  INDEX `fk_vale_combustible_has_chofer_vale_combustible1_idx` (`vale_combustible_idvale_combustible` ASC),
  CONSTRAINT `fk_vale_combustible_has_chofer_vale_combustible1`
    FOREIGN KEY (`vale_combustible_idvale_combustible`)
    REFERENCES `itcatramss_6`.`vale_combustible` (`idvale_combustible`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vale_combustible_has_chofer_chofer1`
    FOREIGN KEY (`chofer_idchofer`)
    REFERENCES `itcatramss_6`.`chofer` (`idchofer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vale_combustible_tiene_emisor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vale_combustible_tiene_emisor` (
  `vale_combustible_idvale_combustible` VARCHAR(10) NOT NULL,
  `usuario_idusuario` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vale_combustible_idvale_combustible`, `usuario_idusuario`),
  INDEX `fk_vale_combustible_has_usuario_usuario1_idx` (`usuario_idusuario` ASC),
  INDEX `fk_vale_combustible_has_usuario_vale_combustible1_idx` (`vale_combustible_idvale_combustible` ASC),
  CONSTRAINT `fk_vale_combustible_has_usuario_vale_combustible1`
    FOREIGN KEY (`vale_combustible_idvale_combustible`)
    REFERENCES `itcatramss_6`.`vale_combustible` (`idvale_combustible`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vale_combustible_has_usuario_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `itcatramss_6`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vale_combustible_tiene_vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vale_combustible_tiene_vehiculo` (
  `vale_combustible_idvale_combustible` VARCHAR(10) NOT NULL,
  `vehiculo_idvehiculo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vale_combustible_idvale_combustible`, `vehiculo_idvehiculo`),
  INDEX `fk_vale_combustible_has_vehiculo_vehiculo1_idx` (`vehiculo_idvehiculo` ASC),
  INDEX `fk_vale_combustible_has_vehiculo_vale_combustible1_idx` (`vale_combustible_idvale_combustible` ASC),
  CONSTRAINT `fk_vale_combustible_has_vehiculo_vale_combustible1`
    FOREIGN KEY (`vale_combustible_idvale_combustible`)
    REFERENCES `itcatramss_6`.`vale_combustible` (`idvale_combustible`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vale_combustible_has_vehiculo_vehiculo1`
    FOREIGN KEY (`vehiculo_idvehiculo`)
    REFERENCES `itcatramss_6`.`vehiculo` (`idvehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`registro_viaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`registro_viaje` (
  `idregistro_viaje` VARCHAR(10) NOT NULL,
  `fecha_ida` DATETIME NOT NULL,
  `fecha_llegada` DATETIME NULL,
  `observacion_viaje` VARCHAR(300) NULL,
  PRIMARY KEY (`idregistro_viaje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`registro_viaje_tiene_vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`registro_viaje_tiene_vehiculo` (
  `registro_viaje_idregistro_viaje` VARCHAR(10) NOT NULL,
  `vehiculo_idvehiculo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`registro_viaje_idregistro_viaje`, `vehiculo_idvehiculo`),
  INDEX `fk_registro_viaje_has_vehiculo_vehiculo1_idx` (`vehiculo_idvehiculo` ASC),
  INDEX `fk_registro_viaje_has_vehiculo_registro_viaje1_idx` (`registro_viaje_idregistro_viaje` ASC),
  CONSTRAINT `fk_registro_viaje_has_vehiculo_registro_viaje1`
    FOREIGN KEY (`registro_viaje_idregistro_viaje`)
    REFERENCES `itcatramss_6`.`registro_viaje` (`idregistro_viaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_registro_viaje_has_vehiculo_vehiculo1`
    FOREIGN KEY (`vehiculo_idvehiculo`)
    REFERENCES `itcatramss_6`.`vehiculo` (`idvehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`vale_combustible_tiene_registro_viaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`vale_combustible_tiene_registro_viaje` (
  `vale_combustible_idvale_combustible` VARCHAR(10) NOT NULL,
  `registro_viaje_idregistro_viaje` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`vale_combustible_idvale_combustible`, `registro_viaje_idregistro_viaje`),
  INDEX `fk_vale_combustible_has_registro_viaje_registro_viaje1_idx` (`registro_viaje_idregistro_viaje` ASC),
  INDEX `fk_vale_combustible_has_registro_viaje_vale_combustible1_idx` (`vale_combustible_idvale_combustible` ASC),
  CONSTRAINT `fk_vale_combustible_has_registro_viaje_vale_combustible1`
    FOREIGN KEY (`vale_combustible_idvale_combustible`)
    REFERENCES `itcatramss_6`.`vale_combustible` (`idvale_combustible`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vale_combustible_has_registro_viaje_registro_viaje1`
    FOREIGN KEY (`registro_viaje_idregistro_viaje`)
    REFERENCES `itcatramss_6`.`registro_viaje` (`idregistro_viaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `itcatramss_6`.`registro_viaje_tiene_chofer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itcatramss_6`.`registro_viaje_tiene_chofer` (
  `registro_viaje_idregistro_viaje` VARCHAR(10) NOT NULL,
  `chofer_idchofer` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`registro_viaje_idregistro_viaje`, `chofer_idchofer`),
  INDEX `fk_registro_viaje_has_chofer_chofer1_idx` (`chofer_idchofer` ASC),
  INDEX `fk_registro_viaje_has_chofer_registro_viaje1_idx` (`registro_viaje_idregistro_viaje` ASC),
  CONSTRAINT `fk_registro_viaje_has_chofer_registro_viaje1`
    FOREIGN KEY (`registro_viaje_idregistro_viaje`)
    REFERENCES `itcatramss_6`.`registro_viaje` (`idregistro_viaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_registro_viaje_has_chofer_chofer1`
    FOREIGN KEY (`chofer_idchofer`)
    REFERENCES `itcatramss_6`.`chofer` (`idchofer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
