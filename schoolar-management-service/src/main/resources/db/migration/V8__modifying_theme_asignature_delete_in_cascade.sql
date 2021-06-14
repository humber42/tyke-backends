ALTER TABLE public.asignatura_tema DROP CONSTRAINT asignatura_tema_id_asignatura_fkey;
ALTER TABLE public.asignatura_tema
ADD CONSTRAINT asignatura_tema_id_asignatura_fkey
FOREIGN KEY (id_asignatura) REFERENCES public.asignatura (id) ON DELETE CASCADE;
ALTER TABLE public.asignatura_tema DROP CONSTRAINT asignatura_tema_id_tema_fkey;
ALTER TABLE public.asignatura_tema
ADD CONSTRAINT asignatura_tema_id_tema_fkey
FOREIGN KEY (id_tema) REFERENCES public.tema (id) ON DELETE CASCADE;