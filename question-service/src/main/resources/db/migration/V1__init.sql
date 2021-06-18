----------------------------------------------------
--------          Questions DB                ------
--------  Author:Humberto Cabrera Domínguez   ------
--------                                      ------
----------------------------------------------------


create table if not exists pista
(
  id          bigserial not null
    constraint ayuda_pkey
    primary key,
  texto_ayuda varchar(255)
);

alter table pista
  owner to postgres;

create table if not exists respuesta
(
  id           bigserial    not null
    constraint respuesta_pkey
    primary key,
  texto        varchar(255) not null,
  correcta     boolean      not null,
  "puntuación" integer
);

alter table respuesta
  owner to postgres;

create table if not exists tipo_pregunta
(
  id   bigserial    not null
    constraint tipo_pregunta_pkey
    primary key,
  tipo varchar(255) not null
);

alter table tipo_pregunta
  owner to postgres;

create table if not exists pregunta
(
  id                                  bigserial not null
    constraint pregunta_pkey
    primary key,
  titulo_pregunta                     varchar(255),
  id_asignatura                       bigint,
  id_tipo_pregunta                    bigint
    constraint fkeu_tipo_pregunta_pkey
    references tipo_pregunta,
  tiempo_en_segundos                  integer,
  cant_puntos_completar_correctamente integer
);

alter table pregunta
  owner to postgres;

create table if not exists feedback
(
  id          bigserial not null
    constraint feedback_pkey
    primary key,
  id_perfil   bigint,
  feedback    varchar(255),
  id_pregunta bigint
    constraint fkey_feedback_pregunta_pkey
    references pregunta
);

alter table feedback
  owner to postgres;

create table if not exists pregunta_respuesta
(
  id           bigserial not null
    constraint pregunta_respuesta_pkey
    primary key,
  id_pregunta  bigint    not null
    constraint fkey_pregunta_respuesta_pregunta
    references pregunta,
  id_respuesta bigint    not null
    constraint fkey_pregunta_respuesta_respuesta
    references respuesta
);

alter table pregunta_respuesta
  owner to postgres;

create table if not exists profile_respuesta_pregunta
(
  id              bigserial not null
    constraint profile_respuesta_pregunta_pkey
    primary key,
  id_profile      bigint,
  id_respuesta    bigint
    constraint fkey_profile_pregunta_respuesta_respuesta
    references respuesta,
  id_pregunta     bigint
    constraint fkey_profile_pregunta_respuesta_pregunta
    references pregunta,
  tiempo_segundos integer
);

alter table profile_respuesta_pregunta
  owner to postgres;

create table if not exists bonificacion_pregunta_tiempo
(
  id           bigserial not null
    constraint bonificacion_pregunta_timepo_pkey
    primary key,
  id_pregunta  bigint
    constraint fkey_bonificacion_pregunta_tiempo
    references pregunta,
  tiempo_menor bigint,
  bonificacion integer
);

alter table bonificacion_pregunta_tiempo
  owner to postgres;

create table if not exists pista_pregunta
(
  id_pregunta bigint not null
    constraint fk_pista_pregunta_pregunta
    references pregunta,
  id_pista    bigint not null
    constraint fk_pista_pregunta_pista
    references pista,
  constraint pista_pregunta_pkey
  primary key (id_pregunta, id_pista)
);

alter table pista_pregunta
  owner to postgres;

