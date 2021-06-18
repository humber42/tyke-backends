create table if not exists tipo_pista
(
  id          bigserial not null
    constraint tipo_pista_pkey
    primary key,
  tipo varchar(255),
  puntos_pista int,
  puntos_juego int
);

Alter table public.pista add id_tipo_pista int not null;


ALTER TABLE public.pista
  ADD CONSTRAINT pista_tipo_pista___fk
FOREIGN KEY (id_tipo_pista) REFERENCES tipo_pista (id);