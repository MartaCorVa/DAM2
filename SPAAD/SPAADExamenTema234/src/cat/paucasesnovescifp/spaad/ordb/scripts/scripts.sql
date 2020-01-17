-- Creació de l'esquema
CREATE SCHEMA "Examen" AUTHORIZATION usuari;

-- Tipus
CREATE TYPE "Examen".t_titols_projectes AS
(
    titol character varying(100)
);

ALTER TYPE "Examen".t_titols_projectes
    OWNER TO usuari;

-- Taula Assistents
CREATE TABLE "Examen"."Assistents"
(
    nif_assistent character varying(9) NOT NULL,
    nom_assistent character varying(50) NOT NULL,
    titols "Examen".t_titols_projectes,
    PRIMARY KEY (nif_assistent)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE "Examen"."Assistents"
    OWNER to usuari;

-- Insert
insert into "Examen"."Assistents" (nif_assistent, nom_assistent, titols) values ('45434543X', 'Joselito', ROW('Hola'));