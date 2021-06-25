ALTER TABLE public.pista_pregunta ADD id bigserial NOT NULL;
CREATE UNIQUE INDEX pista_pregunta_id_uindex ON public.pista_pregunta (id);
ALTER TABLE public.pista_pregunta DROP CONSTRAINT pista_pregunta_pkey;
ALTER TABLE public.pista_pregunta ADD CONSTRAINT pista_pregunta_pk PRIMARY KEY (id);
