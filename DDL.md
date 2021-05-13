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

CREATE TABLE `database`.`odrine` (
  `idodrine` INT NOT NULL AUTO_INCREMENT,
  `importo` FLOAT NULL,
  `DATA` DATE NULL,
  PRIMARY KEY (`idodrine`));
  
  
CREATE TABLE `database`.`dettagli_ordine` (
  `idordine` INT NOT NULL,
  `idarticolo` INT NOT NULL,
  `quantita` INT NULL,
  PRIMARY KEY (`idordine`, `idarticolo`),
  INDEX `idarticolo_idx` (`idarticolo` ASC) VISIBLE,
  CONSTRAINT `idordine`
    FOREIGN KEY (`idordine`)
    REFERENCES `database`.`odrine` (`idodrine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idarticolo`
    FOREIGN KEY (`idarticolo`)
    REFERENCES `database`.`articoli` (`idarticoli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
