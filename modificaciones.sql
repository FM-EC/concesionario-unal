-- -----------------------------------------------------
-- Agregar campo cedula en la tabla profile
-- -----------------------------------------------------
ALTER TABLE profile ADD idCard VARCHAR(15) NOT NULL AFTER idUser
