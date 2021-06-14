ALTER TABLE public.signature_faculty DROP CONSTRAINT signature_faculty_facultad_id_fk;
ALTER TABLE public.signature_faculty RENAME COLUMN id_faculty TO id_career;
ALTER TABLE public.signature_faculty RENAME TO signature_career;
ALTER TABLE public.signature_career
  ADD CONSTRAINT signature_faculty_career_id_fk
FOREIGN KEY (id_career) REFERENCES public.carrera (id);