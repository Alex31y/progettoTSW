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

CREATE TABLE odrine (
   idordine int NOT NULL AUTO_INCREMENT,
   importo float DEFAULT NULL,
   DATA varchar(35) DEFAULT NULL,
   utente varchar(15) DEFAULT NULL,
   PRIMARY KEY (idordine),
   KEY utentte_idx (utente),
   CONSTRAINT utentte FOREIGN KEY (utente) REFERENCES utente (nickname)
 ) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
  
  
CREATE TABLE dettagli_ordine (
   utente varchar(15) NOT NULL,
   idarticolo int NOT NULL,
   quantita int DEFAULT NULL,
   numero_ordine int DEFAULT NULL,
   KEY idarticolo_idx (idarticolo),
   KEY utente_idx (utente),
   CONSTRAINT idarticolo FOREIGN KEY (idarticolo) REFERENCES articoli (idarticoli),
   CONSTRAINT utente FOREIGN KEY (utente) REFERENCES utente (nickname)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 
 
 CREATE TABLE `database`.`dettagli_utente` (
  `via` VARCHAR(45) NOT NULL,
  `cap` VARCHAR(6) NULL,
  `telefono` VARCHAR(12) NULL,
  `nickname` VARCHAR(45) NULL,
  PRIMARY KEY (`via`),
  INDEX `nickname_idx` (`nickname` ASC) VISIBLE,
  CONSTRAINT `nickname`
    FOREIGN KEY (`nickname`)
    REFERENCES `database`.`utente` (`nickname`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);





//Fabio DDL
CREATE TABLE `articoli` (
  `idarticoli` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `immagine` varchar(45) DEFAULT NULL,
  `prezzo` int DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idarticoli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `dettagli_ordine` (
  `utente` varchar(15) NOT NULL,
  `idarticolo` int NOT NULL,
  `quantita` int DEFAULT NULL,
  `numero_ordine` int DEFAULT NULL,
  KEY `utente_idx` (`utente`),
  CONSTRAINT `utente` FOREIGN KEY (`utente`) REFERENCES `utente` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `dettagli_utente` (
  `via` varchar(45) DEFAULT NULL,
  `cap` varchar(6) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `nickname` varchar(45) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nickname`),
  KEY `nickname_idx` (`nickname`),
  CONSTRAINT `nickname` FOREIGN KEY (`nickname`) REFERENCES `utente` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `odrine` (
  `idordine` int NOT NULL AUTO_INCREMENT,
  `importo` float DEFAULT NULL,
  `DATA` varchar(35) DEFAULT NULL,
  `utente` varchar(15) DEFAULT NULL,
  `consegnato` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idordine`),
  KEY `utentte_idx` (`utente`),
  CONSTRAINT `utentte` FOREIGN KEY (`utente`) REFERENCES `utente` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `utente` (
  `nickname` varchar(15) NOT NULL,
  `tipo` int NOT NULL,
  `passw` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `numero_ordini` int DEFAULT NULL,
  PRIMARY KEY (`nickname`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
