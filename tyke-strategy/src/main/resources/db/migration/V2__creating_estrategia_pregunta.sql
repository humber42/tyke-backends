CREATE TABLE public.estrategia_pregunta
(
  id serial PRIMARY KEY NOT NULL,
  id_pregunta bigint,
  id_estrategia bigint,
  CONSTRAINT estrategia_pregunta_estrategia_id_estrategia_fk FOREIGN KEY (id_estrategia) REFERENCES public.estrategia (id_estrategia) ON DELETE CASCADE
);
CREATE UNIQUE INDEX estrategia_pregunta_id_uindex ON public.estrategia_pregunta (id);