/*
Navicat PGSQL Data Transfer

Source Server         : Postgres Coneccion
Source Server Version : 90300
Source Host           : localhost:5432
Source Database       : tyke-strategy
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90300
File Encoding         : 65001

Date: 2021-05-13 21:21:55
*/


-- ----------------------------
-- Sequence structure for estrategia_grupo_id_estrategia_grupo_seq
-- ----------------------------
CREATE SEQUENCE "public"."estrategia_grupo_id_estrategia_grupo_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for estrategia_id_estrategia_seq
-- ----------------------------
CREATE SEQUENCE "public"."estrategia_id_estrategia_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for estrategia_tema_id_estrategia_tema_seq
-- ----------------------------
CREATE SEQUENCE "public"."estrategia_tema_id_estrategia_tema_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for insignia_id_insignia_seq
-- ----------------------------
CREATE SEQUENCE "public"."insignia_id_insignia_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for jugador_desafio_id_jugador_desafio_seq
-- ----------------------------
CREATE SEQUENCE "public"."jugador_desafio_id_jugador_desafio_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for jugador_estrategia_id_jugador_estrategia_seq
-- ----------------------------
CREATE SEQUENCE "public"."jugador_estrategia_id_jugador_estrategia_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for jugador_insignia_id_jugador_insignias_seq
-- ----------------------------
CREATE SEQUENCE "public"."jugador_insignia_id_jugador_insignias_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for jugador_regalo_id_jugador_regalos_seq
-- ----------------------------
CREATE SEQUENCE "public"."jugador_regalo_id_jugador_regalos_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for otorgamiento_id_otorgamiento_seq
-- ----------------------------
CREATE SEQUENCE "public"."otorgamiento_id_otorgamiento_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for puntuacion_id_puntuacion_seq
-- ----------------------------
CREATE SEQUENCE "public"."puntuacion_id_puntuacion_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for regalo_id_regalo_seq
-- ----------------------------
CREATE SEQUENCE "public"."regalo_id_regalo_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for rol_profesional_id_rol_profesional_seq
-- ----------------------------
CREATE SEQUENCE "public"."rol_profesional_id_rol_profesional_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for tipo_regalo_id_tipo_regalo_seq
-- ----------------------------
CREATE SEQUENCE "public"."tipo_regalo_id_tipo_regalo_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Table structure for estrategia
-- ----------------------------
DROP TABLE IF EXISTS "public"."estrategia";
CREATE TABLE "public"."estrategia" (
"id_estrategia" int8 DEFAULT nextval('estrategia_id_estrategia_seq'::regclass) NOT NULL,
"puntos" int4,
"nombre" varchar(255) COLLATE "default",
"fecha_creacion " date,
"id_profesor" int8,
"habilitada" bool,
"evaluada" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for estrategia_grupo
-- ----------------------------
DROP TABLE IF EXISTS "public"."estrategia_grupo";
CREATE TABLE "public"."estrategia_grupo" (
"id_estrategia_grupo" int8 DEFAULT nextval('estrategia_grupo_id_estrategia_grupo_seq'::regclass) NOT NULL,
"id_estrategia" int8,
"id_grupo" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for estrategia_tema
-- ----------------------------
DROP TABLE IF EXISTS "public"."estrategia_tema";
CREATE TABLE "public"."estrategia_tema" (
"id_estrategia_tema" int8 DEFAULT nextval('estrategia_tema_id_estrategia_tema_seq'::regclass) NOT NULL,
"id_estrategia" int8,
"id_tema" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for insignia
-- ----------------------------
DROP TABLE IF EXISTS "public"."insignia";
CREATE TABLE "public"."insignia" (
"id_insignia" int8 DEFAULT nextval('insignia_id_insignia_seq'::regclass) NOT NULL,
"nombre" varchar(255) COLLATE "default",
"puntos_avance" int4,
"id_rol" int8,
"puntos_otorgar" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jugador_desafio
-- ----------------------------
DROP TABLE IF EXISTS "public"."jugador_desafio";
CREATE TABLE "public"."jugador_desafio" (
"id_jugador_desafio" int8 DEFAULT nextval('jugador_desafio_id_jugador_desafio_seq'::regclass) NOT NULL,
"id_jugador_desafiante" int8,
"id_jugador_desafiado" int8,
"desafio_entregado" bool,
"desafio_confirmado" bool,
"id_estrategia" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jugador_estrategia
-- ----------------------------
DROP TABLE IF EXISTS "public"."jugador_estrategia";
CREATE TABLE "public"."jugador_estrategia" (
"id_jugador_estrategia" int8 DEFAULT nextval('jugador_estrategia_id_jugador_estrategia_seq'::regclass) NOT NULL,
"id_estrategia" int8,
"id_jugador" int8,
"puntuacion_obtenida" int4,
"completada" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jugador_insignia
-- ----------------------------
DROP TABLE IF EXISTS "public"."jugador_insignia";
CREATE TABLE "public"."jugador_insignia" (
"id_jugador_insignias" int8 DEFAULT nextval('jugador_insignia_id_jugador_insignias_seq'::regclass) NOT NULL,
"id_insignia" int8,
"id_jugador" int8,
"nivel_avance" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jugador_regalo
-- ----------------------------
DROP TABLE IF EXISTS "public"."jugador_regalo";
CREATE TABLE "public"."jugador_regalo" (
"id_jugador_regalos" int8 DEFAULT nextval('jugador_regalo_id_jugador_regalos_seq'::regclass) NOT NULL,
"id_regalo" int8,
"id_jugador" int8,
"cantidad" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for otorgamiento
-- ----------------------------
DROP TABLE IF EXISTS "public"."otorgamiento";
CREATE TABLE "public"."otorgamiento" (
"id_otorgamiento" int8 DEFAULT nextval('otorgamiento_id_otorgamiento_seq'::regclass) NOT NULL,
"cant_puntos" int4,
"otorgamiento" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for puntuacion
-- ----------------------------
DROP TABLE IF EXISTS "public"."puntuacion";
CREATE TABLE "public"."puntuacion" (
"id_puntuacion" int8 DEFAULT nextval('puntuacion_id_puntuacion_seq'::regclass) NOT NULL,
"id_estudiante" int8,
"puntuacion" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for regalo
-- ----------------------------
DROP TABLE IF EXISTS "public"."regalo";
CREATE TABLE "public"."regalo" (
"id_regalo" int8 DEFAULT nextval('regalo_id_regalo_seq'::regclass) NOT NULL,
"id_tipo_regalo" int8,
"id_otorgamiento" int8,
"descripcion" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for rol_profesional
-- ----------------------------
DROP TABLE IF EXISTS "public"."rol_profesional";
CREATE TABLE "public"."rol_profesional" (
"id_rol_profesional" int8 DEFAULT nextval('rol_profesional_id_rol_profesional_seq'::regclass) NOT NULL,
"id_carrera" int8,
"id_tema" int8,
"nombre" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for tipo_regalo
-- ----------------------------
DROP TABLE IF EXISTS "public"."tipo_regalo";
CREATE TABLE "public"."tipo_regalo" (
"id_tipo_regalo" int8 DEFAULT nextval('tipo_regalo_id_tipo_regalo_seq'::regclass) NOT NULL,
"nombre" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."estrategia_grupo_id_estrategia_grupo_seq" OWNED BY "estrategia_grupo"."id_estrategia_grupo";
ALTER SEQUENCE "public"."estrategia_id_estrategia_seq" OWNED BY "estrategia"."id_estrategia";
ALTER SEQUENCE "public"."estrategia_tema_id_estrategia_tema_seq" OWNED BY "estrategia_tema"."id_estrategia_tema";
ALTER SEQUENCE "public"."insignia_id_insignia_seq" OWNED BY "insignia"."id_insignia";
ALTER SEQUENCE "public"."jugador_desafio_id_jugador_desafio_seq" OWNED BY "jugador_desafio"."id_jugador_desafio";
ALTER SEQUENCE "public"."jugador_estrategia_id_jugador_estrategia_seq" OWNED BY "jugador_estrategia"."id_jugador_estrategia";
ALTER SEQUENCE "public"."jugador_insignia_id_jugador_insignias_seq" OWNED BY "jugador_insignia"."id_jugador_insignias";
ALTER SEQUENCE "public"."jugador_regalo_id_jugador_regalos_seq" OWNED BY "jugador_regalo"."id_jugador_regalos";
ALTER SEQUENCE "public"."otorgamiento_id_otorgamiento_seq" OWNED BY "otorgamiento"."id_otorgamiento";
ALTER SEQUENCE "public"."puntuacion_id_puntuacion_seq" OWNED BY "puntuacion"."id_puntuacion";
ALTER SEQUENCE "public"."regalo_id_regalo_seq" OWNED BY "regalo"."id_regalo";
ALTER SEQUENCE "public"."rol_profesional_id_rol_profesional_seq" OWNED BY "rol_profesional"."id_rol_profesional";
ALTER SEQUENCE "public"."tipo_regalo_id_tipo_regalo_seq" OWNED BY "tipo_regalo"."id_tipo_regalo";

-- ----------------------------
-- Primary Key structure for table estrategia
-- ----------------------------
ALTER TABLE "public"."estrategia" ADD PRIMARY KEY ("id_estrategia");

-- ----------------------------
-- Primary Key structure for table estrategia_grupo
-- ----------------------------
ALTER TABLE "public"."estrategia_grupo" ADD PRIMARY KEY ("id_estrategia_grupo");

-- ----------------------------
-- Primary Key structure for table estrategia_tema
-- ----------------------------
ALTER TABLE "public"."estrategia_tema" ADD PRIMARY KEY ("id_estrategia_tema");

-- ----------------------------
-- Primary Key structure for table insignia
-- ----------------------------
ALTER TABLE "public"."insignia" ADD PRIMARY KEY ("id_insignia");

-- ----------------------------
-- Primary Key structure for table jugador_desafio
-- ----------------------------
ALTER TABLE "public"."jugador_desafio" ADD PRIMARY KEY ("id_jugador_desafio");

-- ----------------------------
-- Primary Key structure for table jugador_estrategia
-- ----------------------------
ALTER TABLE "public"."jugador_estrategia" ADD PRIMARY KEY ("id_jugador_estrategia");

-- ----------------------------
-- Primary Key structure for table jugador_insignia
-- ----------------------------
ALTER TABLE "public"."jugador_insignia" ADD PRIMARY KEY ("id_jugador_insignias");

-- ----------------------------
-- Primary Key structure for table jugador_regalo
-- ----------------------------
ALTER TABLE "public"."jugador_regalo" ADD PRIMARY KEY ("id_jugador_regalos");

-- ----------------------------
-- Primary Key structure for table otorgamiento
-- ----------------------------
ALTER TABLE "public"."otorgamiento" ADD PRIMARY KEY ("id_otorgamiento");

-- ----------------------------
-- Primary Key structure for table puntuacion
-- ----------------------------
ALTER TABLE "public"."puntuacion" ADD PRIMARY KEY ("id_puntuacion");

-- ----------------------------
-- Primary Key structure for table regalo
-- ----------------------------
ALTER TABLE "public"."regalo" ADD PRIMARY KEY ("id_regalo");

-- ----------------------------
-- Primary Key structure for table rol_profesional
-- ----------------------------
ALTER TABLE "public"."rol_profesional" ADD PRIMARY KEY ("id_rol_profesional");

-- ----------------------------
-- Primary Key structure for table tipo_regalo
-- ----------------------------
ALTER TABLE "public"."tipo_regalo" ADD PRIMARY KEY ("id_tipo_regalo");

-- ----------------------------
-- Foreign Key structure for table "public"."estrategia_grupo"
-- ----------------------------
ALTER TABLE "public"."estrategia_grupo" ADD FOREIGN KEY ("id_estrategia") REFERENCES "public"."estrategia" ("id_estrategia") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."estrategia_tema"
-- ----------------------------
ALTER TABLE "public"."estrategia_tema" ADD FOREIGN KEY ("id_estrategia") REFERENCES "public"."estrategia" ("id_estrategia") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."insignia"
-- ----------------------------
ALTER TABLE "public"."insignia" ADD FOREIGN KEY ("id_rol") REFERENCES "public"."rol_profesional" ("id_rol_profesional") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."jugador_desafio"
-- ----------------------------
ALTER TABLE "public"."jugador_desafio" ADD FOREIGN KEY ("id_estrategia") REFERENCES "public"."estrategia" ("id_estrategia") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."jugador_estrategia"
-- ----------------------------
ALTER TABLE "public"."jugador_estrategia" ADD FOREIGN KEY ("id_estrategia") REFERENCES "public"."estrategia" ("id_estrategia") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."jugador_insignia"
-- ----------------------------
ALTER TABLE "public"."jugador_insignia" ADD FOREIGN KEY ("id_insignia") REFERENCES "public"."insignia" ("id_insignia") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."jugador_regalo"
-- ----------------------------
ALTER TABLE "public"."jugador_regalo" ADD FOREIGN KEY ("id_regalo") REFERENCES "public"."regalo" ("id_regalo") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."regalo"
-- ----------------------------
ALTER TABLE "public"."regalo" ADD FOREIGN KEY ("id_tipo_regalo") REFERENCES "public"."tipo_regalo" ("id_tipo_regalo") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."regalo" ADD FOREIGN KEY ("id_otorgamiento") REFERENCES "public"."otorgamiento" ("id_otorgamiento") ON DELETE NO ACTION ON UPDATE NO ACTION;
