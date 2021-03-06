-- MySQL Script generated by MySQL Workbench
-- Tue Mar 29 22:39:08 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema adminio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema adminio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `adminio` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `adminio` ;

-- -----------------------------------------------------
-- Table `adminio`.`administrator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adminio`.`administrator` (
  `id_administrator` INT NOT NULL AUTO_INCREMENT,
  `name_administrator` VARCHAR(255) NOT NULL DEFAULT 'Admin',
  `email_administrator` VARCHAR(255) NOT NULL,
  `password_administrator` VARCHAR(255) NOT NULL,
  `phone_administrator` INT NULL DEFAULT NULL,
  `description_administrator` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_administrator`),
  UNIQUE INDEX `email_administrator_UNIQUE` (`email_administrator` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adminio`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adminio`.`member` (
  `id_member` INT NOT NULL AUTO_INCREMENT,
  `name_member` VARCHAR(255) NOT NULL DEFAULT 'Admin',
  `email_member` VARCHAR(255) NOT NULL,
  `password_member` VARCHAR(255) NOT NULL,
  `phone_member` INT NULL DEFAULT NULL,
  `description_member` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_member`),
  UNIQUE INDEX `email_administrator_UNIQUE` (`email_member` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adminio`.`work`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adminio`.`work` (
  `id_work` INT NOT NULL AUTO_INCREMENT,
  `name_work` VARCHAR(45) NOT NULL,
  `description_work` VARCHAR(45) NULL DEFAULT NULL,
  `priority_work` VARCHAR(55) NOT NULL DEFAULT 'normal',
  `process_work` VARCHAR(45) NULL DEFAULT NULL,
  `startdate_work` DATE NULL DEFAULT NULL,
  `enddate_work` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_work`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adminio`.`workgroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adminio`.`workgroup` (
  `id_workgroup` INT NOT NULL AUTO_INCREMENT,
  `name_workgroup` VARCHAR(255) NOT NULL,
  `description_workgroup` LONGTEXT NULL DEFAULT NULL,
  `administrator_id_administrator` INT NOT NULL,
  PRIMARY KEY (`id_workgroup`),
  INDEX `fk_workgroup_administrator_idx` (`administrator_id_administrator` ASC) VISIBLE,
  CONSTRAINT `fk_workgroup_administrator`
    FOREIGN KEY (`administrator_id_administrator`)
    REFERENCES `adminio`.`administrator` (`id_administrator`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adminio`.`workgroup_has_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adminio`.`workgroup_has_member` (
  `workgroup_id_workgroup` INT NOT NULL,
  `member_id_member` INT NOT NULL,
  PRIMARY KEY (`workgroup_id_workgroup`, `member_id_member`),
  INDEX `fk_workgroup_has_member_member1_idx` (`member_id_member` ASC) VISIBLE,
  INDEX `fk_workgroup_has_member_workgroup1_idx` (`workgroup_id_workgroup` ASC) VISIBLE,
  CONSTRAINT `fk_workgroup_has_member_member1`
    FOREIGN KEY (`member_id_member`)
    REFERENCES `adminio`.`member` (`id_member`),
  CONSTRAINT `fk_workgroup_has_member_workgroup1`
    FOREIGN KEY (`workgroup_id_workgroup`)
    REFERENCES `adminio`.`workgroup` (`id_workgroup`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adminio`.`workgroup_has_work`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adminio`.`workgroup_has_work` (
  `workgroup_id_workgroup` INT NOT NULL,
  `work_id_work` INT NOT NULL,
  PRIMARY KEY (`workgroup_id_workgroup`, `work_id_work`),
  INDEX `fk_workgroup_has_work_work1_idx` (`work_id_work` ASC) VISIBLE,
  INDEX `fk_workgroup_has_work_workgroup1_idx` (`workgroup_id_workgroup` ASC) VISIBLE,
  CONSTRAINT `fk_workgroup_has_work_work1`
    FOREIGN KEY (`work_id_work`)
    REFERENCES `adminio`.`work` (`id_work`),
  CONSTRAINT `fk_workgroup_has_work_workgroup1`
    FOREIGN KEY (`workgroup_id_workgroup`)
    REFERENCES `adminio`.`workgroup` (`id_workgroup`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
