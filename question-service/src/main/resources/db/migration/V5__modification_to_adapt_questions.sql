ALTER TABLE public.pregunta_respuesta
  ADD pregunta_padre bigint;
ALTER TABLE public.pregunta_respuesta
  ADD orden int;

ALTER TABLE public.pregunta_respuesta
  ADD CONSTRAINT pregunta_respuesta___pregunta_padre_fk
FOREIGN KEY (pregunta_padre) REFERENCES public.pregunta (id);
