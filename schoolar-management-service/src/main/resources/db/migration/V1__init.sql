/*
Navicat PGSQL Data Transfer

Source Server         : PostgresConection
Source Server Version : 90300
Source Host           : localhost:5432
Source Database       : gamae-scholar-management
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90300
File Encoding         : 65001

Date: 2020-11-07 19:00:16
*/


-- ----------------------------
-- Sequence structure for anno_id_anno_seq
-- ----------------------------

CREATE SEQUENCE "public"."anno_id_anno_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 5
 CACHE 1;
SELECT setval('"public"."anno_id_anno_seq"', 5, true);

-- ----------------------------
-- Sequence structure for asignatura_id_asignatura_seq
-- ----------------------------

CREATE SEQUENCE "public"."asignatura_id_asignatura_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 3
 CACHE 1;
SELECT setval('"public"."asignatura_id_asignatura_seq"', 3, true);

-- ----------------------------
-- Sequence structure for carrera_id_carrera_seq
-- ----------------------------

CREATE SEQUENCE "public"."carrera_id_carrera_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for curso_id_curso_seq
-- ----------------------------

CREATE SEQUENCE "public"."curso_id_curso_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for estudiante_id_estudiante_seq
-- ----------------------------

CREATE SEQUENCE "public"."estudiante_id_estudiante_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for facultad_id_facultad_seq
-- ----------------------------

CREATE SEQUENCE "public"."facultad_id_facultad_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for grupo_id_seq
-- ----------------------------

CREATE SEQUENCE "public"."grupo_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for profesor_id_profesor_seq
-- ----------------------------

CREATE SEQUENCE "public"."profesor_id_profesor_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for semestre_id_semestre_seq
-- ----------------------------

CREATE SEQUENCE "public"."semestre_id_semestre_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Table structure for anno
-- ----------------------------
DROP TABLE IF EXISTS "public"."anno";
CREATE TABLE "public"."anno" (
 "id" int4 DEFAULT nextval('anno_id_anno_seq'::regclass) NOT NULL,
 "anno" varchar(40) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of anno
-- ----------------------------
INSERT INTO "public"."anno" VALUES ('1', 'Primero');
INSERT INTO "public"."anno" VALUES ('2', 'Segundo');
INSERT INTO "public"."anno" VALUES ('3', 'Tercero');
INSERT INTO "public"."anno" VALUES ('4', 'Cuarto');

-- ----------------------------
-- Table structure for anno_grupo
-- ----------------------------
DROP TABLE IF EXISTS "public"."anno_grupo";
CREATE TABLE "public"."anno_grupo" (
 "id_anno" int4 NOT NULL,
 "id_grupo" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of anno_grupo
-- ----------------------------

-- ----------------------------
-- Table structure for anno_semestre
-- ----------------------------
DROP TABLE IF EXISTS "public"."anno_semestre";
CREATE TABLE "public"."anno_semestre" (
 "id_anno" int4 NOT NULL,
 "id_semestre" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of anno_semestre
-- ----------------------------

-- ----------------------------
-- Table structure for asignatura
-- ----------------------------
DROP TABLE IF EXISTS "public"."asignatura";
CREATE TABLE "public"."asignatura" (
 "id" int4 DEFAULT nextval('asignatura_id_asignatura_seq'::regclass) NOT NULL,
 "nombre" varchar(40) COLLATE "default" NOT NULL,
 "activo" bool DEFAULT false NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of asignatura
-- ----------------------------
INSERT INTO "public"."asignatura" VALUES ('1', 'Matematica 3', 't');
INSERT INTO "public"."asignatura" VALUES ('2', 'Matematica', 't');

-- ----------------------------
-- Table structure for asignatura_profesor_grupo
-- ----------------------------
DROP TABLE IF EXISTS "public"."asignatura_profesor_estudiante";
CREATE TABLE "public"."asignatura_profesor_estudiante" (
 "id_asignatura" int4 NOT NULL,
 "id_profesor" int4 NOT NULL,
 "id_estudiante" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of asignatura_profesor_grupo
-- ----------------------------

-- ----------------------------
-- Table structure for asignatura_tema
-- ----------------------------
DROP TABLE IF EXISTS "public"."asignatura_tema";
CREATE TABLE "public"."asignatura_tema" (
 "id_asignatura" int4 NOT NULL,
 "id_tema" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of asignatura_tema
-- ----------------------------

-- ----------------------------
-- Table structure for carrera
-- ----------------------------
DROP TABLE IF EXISTS "public"."carrera";
CREATE TABLE "public"."carrera" (
 "id" int4 DEFAULT nextval('carrera_id_carrera_seq'::regclass) NOT NULL,
 "nombre" varchar(30) COLLATE "default" NOT NULL,
 "siglas" varchar(10) COLLATE "default" NOT NULL,
 "id_facultad" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of carrera
-- ----------------------------

-- ----------------------------
-- Table structure for curso
-- ----------------------------
DROP TABLE IF EXISTS "public"."curso";
CREATE TABLE "public"."curso" (
 "id" int4 DEFAULT nextval('curso_id_curso_seq'::regclass) NOT NULL,
 "curso" varchar(30) COLLATE "default" NOT NULL,
 "activo" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of curso
-- ----------------------------

-- ----------------------------
-- Table structure for curso_anno
-- ----------------------------
DROP TABLE IF EXISTS "public"."curso_anno";
CREATE TABLE "public"."curso_anno" (
 "id_curso" int4 NOT NULL,
 "id_anno" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of curso_anno
-- ----------------------------

-- ----------------------------
-- Table structure for estudiante
-- ----------------------------
DROP TABLE IF EXISTS "public"."estudiante";
CREATE TABLE "public"."estudiante" (
 "id" int4 DEFAULT nextval('estudiante_id_estudiante_seq'::regclass) NOT NULL,
 "nombre" varchar(100) COLLATE "default" NOT NULL,
 "apellido" varchar(30) COLLATE "default",
 "sexo" varchar(15) COLLATE "default" NOT NULL,
 "correo" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of estudiante
-- ----------------------------

-- ----------------------------
-- Table structure for estudiante_grupo
-- ----------------------------
DROP TABLE IF EXISTS "public"."estudiante_grupo";
CREATE TABLE "public"."estudiante_grupo" (
 "id_estudiante" int4 NOT NULL,
 "id_grupo" int4 NOT NULL,
 "id_curso" int4 NOT NULL,
 "id_anno" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of estudiante_grupo
-- ----------------------------

-- ----------------------------
-- Table structure for facultad
-- ----------------------------
DROP TABLE IF EXISTS "public"."facultad";
CREATE TABLE "public"."facultad" (
 "id" int4 DEFAULT nextval('facultad_id_facultad_seq'::regclass) NOT NULL,
 "facultad" varchar(40) COLLATE "default" NOT NULL,
 "siglas" varchar(10) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of facultad
-- ----------------------------

-- ----------------------------
-- Table structure for facultad_curso
-- ----------------------------
DROP TABLE IF EXISTS "public"."facultad_curso";
CREATE TABLE "public"."facultad_curso" (
 "id_facultad" int4 NOT NULL,
 "id_curso" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of facultad_curso
-- ----------------------------


-- ----------------------------
-- Table structure for grupo
-- ----------------------------
DROP TABLE IF EXISTS "public"."grupo";
CREATE TABLE "public"."grupo" (
 "id" int8 DEFAULT nextval('grupo_id_seq'::regclass) NOT NULL,
 "grupo" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of grupo
-- ----------------------------

-- ----------------------------
-- Table structure for profesor
-- ----------------------------
DROP TABLE IF EXISTS "public"."profesor";
CREATE TABLE "public"."profesor" (
 "id" int4 DEFAULT nextval('profesor_id_profesor_seq'::regclass) NOT NULL,
 "nombre" varchar(30) COLLATE "default" NOT NULL,
 "apellidos" varchar(20) COLLATE "default",
 "grado_cientifico" varchar(20) COLLATE "default" NOT NULL,
 "grado_docente" varchar(20) COLLATE "default" NOT NULL,
 "telefono" varchar(15) COLLATE "default",
 "correo" varchar(100) COLLATE "default",
 "permiso" bool DEFAULT false NOT NULL,
 "id_facultad" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of profesor
-- ----------------------------

-- ----------------------------
-- Table structure for semestre
-- ----------------------------
DROP TABLE IF EXISTS "public"."semestre";
CREATE TABLE "public"."semestre" (
 "id" int4 DEFAULT nextval('semestre_id_semestre_seq'::regclass) NOT NULL,
 "semestre" varchar(10) COLLATE "default" NOT NULL,
 "activo" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of semestre
-- ----------------------------

-- ----------------------------
-- Table structure for semestre_asignatura
-- ----------------------------
DROP TABLE IF EXISTS "public"."semestre_asignatura";
CREATE TABLE "public"."semestre_asignatura" (
 "id_semestre" int4 NOT NULL,
 "id_asignatura" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of semestre_asignatura
-- ----------------------------

-- ----------------------------
-- Table structure for tema
-- ----------------------------
DROP TABLE IF EXISTS "public"."tema";
CREATE TABLE "public"."tema" (
 "id" int4 NOT NULL,
 "nombre" varchar(255) COLLATE "default" NOT NULL,
 "desc" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tema
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By
-- ----------------------------
ALTER SEQUENCE "public"."anno_id_anno_seq" OWNED BY "anno"."id";
ALTER SEQUENCE "public"."asignatura_id_asignatura_seq" OWNED BY "asignatura"."id";
ALTER SEQUENCE "public"."carrera_id_carrera_seq" OWNED BY "carrera"."id";
ALTER SEQUENCE "public"."curso_id_curso_seq" OWNED BY "curso"."id";
ALTER SEQUENCE "public"."estudiante_id_estudiante_seq" OWNED BY "estudiante"."id";
ALTER SEQUENCE "public"."facultad_id_facultad_seq" OWNED BY "facultad"."id";
ALTER SEQUENCE "public"."grupo_id_seq" OWNED BY "grupo"."id";
ALTER SEQUENCE "public"."profesor_id_profesor_seq" OWNED BY "profesor"."id";
ALTER SEQUENCE "public"."semestre_id_semestre_seq" OWNED BY "semestre"."id";

-- ----------------------------
-- Primary Key structure for table anno
-- ----------------------------
ALTER TABLE "public"."anno" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table anno_grupo
-- ----------------------------
ALTER TABLE "public"."anno_grupo" ADD PRIMARY KEY ("id_anno", "id_grupo");

-- ----------------------------
-- Primary Key structure for table anno_semestre
-- ----------------------------
ALTER TABLE "public"."anno_semestre" ADD PRIMARY KEY ("id_anno", "id_semestre");

-- ----------------------------
-- Primary Key structure for table asignatura
-- ----------------------------
ALTER TABLE "public"."asignatura" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table asignatura_profesor_grupo
-- ----------------------------
CREATE INDEX "refasignaturas10" ON "public"."asignatura_profesor_estudiante" USING btree (id_asignatura);
CREATE INDEX "refprofesor14" ON "public"."asignatura_profesor_estudiante" USING btree (id_profesor);

-- ----------------------------
-- Primary Key structure for table asignatura_profesor_grupo
-- ----------------------------
ALTER TABLE "public"."asignatura_profesor_estudiante" ADD PRIMARY KEY ("id_asignatura", "id_profesor", "id_estudiante");

-- ----------------------------
-- Primary Key structure for table asignatura_tema
-- ----------------------------
ALTER TABLE "public"."asignatura_tema" ADD PRIMARY KEY ("id_asignatura", "id_tema");

-- ----------------------------
-- Primary Key structure for table carrera
-- ----------------------------
ALTER TABLE "public"."carrera" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table curso
-- ----------------------------
ALTER TABLE "public"."curso" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table curso_anno
-- ----------------------------
ALTER TABLE "public"."curso_anno" ADD PRIMARY KEY ("id_curso", "id_anno");

-- ----------------------------
-- Primary Key structure for table estudiante
-- ----------------------------
ALTER TABLE "public"."estudiante" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table estudiante_grupo
-- ----------------------------
ALTER TABLE "public"."estudiante_grupo" ADD PRIMARY KEY ("id_estudiante", "id_grupo", "id_curso", "id_anno");

-- ----------------------------
-- Primary Key structure for table facultad
-- ----------------------------
ALTER TABLE "public"."facultad" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table facultad_curso
-- ----------------------------
ALTER TABLE "public"."facultad_curso" ADD PRIMARY KEY ("id_facultad", "id_curso");


-- ----------------------------
-- Primary Key structure for table grupo
-- ----------------------------
ALTER TABLE "public"."grupo" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table profesor
-- ----------------------------
ALTER TABLE "public"."profesor" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table semestre
-- ----------------------------
ALTER TABLE "public"."semestre" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table semestre_asignatura
-- ----------------------------
ALTER TABLE "public"."semestre_asignatura" ADD PRIMARY KEY ("id_semestre", "id_asignatura");

-- ----------------------------
-- Primary Key structure for table tema
-- ----------------------------
ALTER TABLE "public"."tema" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."anno_grupo"
-- ----------------------------
ALTER TABLE "public"."anno_grupo" ADD FOREIGN KEY ("id_grupo") REFERENCES "public"."grupo" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."anno_grupo" ADD FOREIGN KEY ("id_anno") REFERENCES "public"."anno" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."anno_semestre"
-- ----------------------------
ALTER TABLE "public"."anno_semestre" ADD FOREIGN KEY ("id_anno") REFERENCES "public"."anno" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."anno_semestre" ADD FOREIGN KEY ("id_semestre") REFERENCES "public"."semestre" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."asignatura_profesor_grupo"
-- ----------------------------
ALTER TABLE "public"."asignatura_profesor_estudiante" ADD FOREIGN KEY ("id_profesor") REFERENCES "public"."profesor" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."asignatura_profesor_estudiante" ADD FOREIGN KEY ("id_asignatura") REFERENCES "public"."asignatura" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."asignatura_profesor_estudiante" ADD FOREIGN KEY ("id_estudiante") REFERENCES "public"."estudiante" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."asignatura_tema"
-- ----------------------------
ALTER TABLE "public"."asignatura_tema" ADD FOREIGN KEY ("id_tema") REFERENCES "public"."tema" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."asignatura_tema" ADD FOREIGN KEY ("id_asignatura") REFERENCES "public"."asignatura" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."carrera"
-- ----------------------------
ALTER TABLE "public"."carrera" ADD FOREIGN KEY ("id_facultad") REFERENCES "public"."facultad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."curso_anno"
-- ----------------------------
ALTER TABLE "public"."curso_anno" ADD FOREIGN KEY ("id_anno") REFERENCES "public"."anno" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."curso_anno" ADD FOREIGN KEY ("id_curso") REFERENCES "public"."curso" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."estudiante_grupo"
-- ----------------------------
ALTER TABLE "public"."estudiante_grupo" ADD FOREIGN KEY ("id_grupo") REFERENCES "public"."grupo" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."estudiante_grupo" ADD FOREIGN KEY ("id_anno") REFERENCES "public"."anno" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."estudiante_grupo" ADD FOREIGN KEY ("id_estudiante") REFERENCES "public"."estudiante" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."estudiante_grupo" ADD FOREIGN KEY ("id_curso") REFERENCES "public"."curso" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."facultad_curso"
-- ----------------------------
ALTER TABLE "public"."facultad_curso" ADD FOREIGN KEY ("id_curso") REFERENCES "public"."curso" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."facultad_curso" ADD FOREIGN KEY ("id_facultad") REFERENCES "public"."facultad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."profesor"
-- ----------------------------
ALTER TABLE "public"."profesor" ADD FOREIGN KEY ("id_facultad") REFERENCES "public"."facultad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."semestre_asignatura"
-- ----------------------------
ALTER TABLE "public"."semestre_asignatura" ADD FOREIGN KEY ("id_semestre") REFERENCES "public"."semestre" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."semestre_asignatura" ADD FOREIGN KEY ("id_asignatura") REFERENCES "public"."asignatura" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
