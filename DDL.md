CREATE TABLE articoli (
idarticoli int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(45) NOT NULL,
descrizione varchar(45) DEFAULT NULL,
immagine varchar(45) DEFAULT NULL,
prezzo int DEFAULT NULL,
)


CREATE TABLE `database`.`utente` (
  `nickname` VARCHAR(15) NOT NULL,
  `tipo` INT NOT NULL,
  `passw` VARCHAR(15) NOT NULL,
  `email` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`nickname`),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

