ALTER TABLE public.grupo ADD id_carrera int NULL;
ALTER TABLE public.grupo
ADD CONSTRAINT grupo_carrera_id_fk
FOREIGN KEY (id_carrera) REFERENCES public.carrera (id) ON DELETE CASCADE;