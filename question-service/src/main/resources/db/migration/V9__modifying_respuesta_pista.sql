-- ##borrando tablas sobrantes##
drop table pregunta_respuesta;
drop table pista_pregunta;

-- Modificando tabla respuesta y pregunta
ALTER TABLE public.respuesta ADD correcta boolean NULL;
ALTER TABLE public.respuesta ADD orden int NULL;
ALTER TABLE public.respuesta ADD texto_enlazar varchar(255) NULL;
ALTER TABLE public.respuesta ADD id_pregunta bigint NULL;
ALTER TABLE public.respuesta
  ADD CONSTRAINT respuesta_pregunta_id_fk
FOREIGN KEY (id_pregunta) REFERENCES public.pregunta (id) ON DELETE CASCADE;

ALTER TABLE public.pista ADD id_pregunta bigint NULL;
ALTER TABLE public.pista
  ADD CONSTRAINT pista_pregunta_id_fk
FOREIGN KEY (id_pregunta) REFERENCES public.pregunta (id) ON DELETE CASCADE;