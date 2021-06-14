ALTER TABLE public.estudiante ADD id_facultad int NULL;
ALTER TABLE public.estudiante
ADD CONSTRAINT estudiante___fk_facultad
FOREIGN KEY (id_facultad) REFERENCES public.facultad (id);