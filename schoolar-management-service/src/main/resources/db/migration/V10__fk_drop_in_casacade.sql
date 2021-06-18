ALTER TABLE public.estudiante_grupo DROP CONSTRAINT estudiante_grupo_id_estudiante_fkey;
ALTER TABLE public.estudiante_grupo
ADD CONSTRAINT estudiante_grupo_id_estudiante_fkey
FOREIGN KEY (id_estudiante) REFERENCES public.estudiante (id) ON DELETE CASCADE;
ALTER TABLE public.estudiante_grupo DROP CONSTRAINT estudiante_grupo_id_grupo_fkey;
ALTER TABLE public.estudiante_grupo
ADD CONSTRAINT estudiante_grupo_id_grupo_fkey
FOREIGN KEY (id_grupo) REFERENCES public.grupo (id) ON DELETE CASCADE;
ALTER TABLE public.estudiante_grupo DROP CONSTRAINT estudiante_grupo_id_curso_fkey;
ALTER TABLE public.estudiante_grupo
ADD CONSTRAINT estudiante_grupo_id_curso_fkey
FOREIGN KEY (id_curso) REFERENCES public.curso (id) ON DELETE CASCADE;
ALTER TABLE public.estudiante_grupo DROP CONSTRAINT estudiante_grupo_id_anno_fkey;
ALTER TABLE public.estudiante_grupo
ADD CONSTRAINT estudiante_grupo_id_anno_fkey
FOREIGN KEY (id_anno) REFERENCES public.anno (id) ON DELETE CASCADE;

ALTER TABLE public.anno_grupo DROP CONSTRAINT anno_grupo_id_anno_fkey;
ALTER TABLE public.anno_grupo
ADD CONSTRAINT anno_grupo_id_anno_fkey
FOREIGN KEY (id_anno) REFERENCES public.anno (id) ON DELETE CASCADE;
ALTER TABLE public.anno_grupo DROP CONSTRAINT anno_grupo_id_grupo_fkey;
ALTER TABLE public.anno_grupo
ADD CONSTRAINT anno_grupo_id_grupo_fkey
FOREIGN KEY (id_grupo) REFERENCES public.grupo (id) ON DELETE CASCADE;

ALTER TABLE public.anno_semestre DROP CONSTRAINT anno_semestre_id_anno_fkey;
ALTER TABLE public.anno_semestre
ADD CONSTRAINT anno_semestre_id_anno_fkey
FOREIGN KEY (id_anno) REFERENCES public.anno (id) ON DELETE CASCADE;
ALTER TABLE public.anno_semestre DROP CONSTRAINT anno_semestre_id_semestre_fkey;
ALTER TABLE public.anno_semestre
ADD CONSTRAINT anno_semestre_id_semestre_fkey
FOREIGN KEY (id_semestre) REFERENCES public.semestre (id) ON DELETE CASCADE;

ALTER TABLE public.asignatura_profesor_estudiante DROP CONSTRAINT asignatura_profesor_estudiante_id_asignatura_fkey;
ALTER TABLE public.asignatura_profesor_estudiante
ADD CONSTRAINT asignatura_profesor_estudiante_id_asignatura_fkey
FOREIGN KEY (id_asignatura) REFERENCES public.asignatura (id) ON DELETE CASCADE;
ALTER TABLE public.asignatura_profesor_estudiante DROP CONSTRAINT asignatura_profesor_estudiante_id_profesor_fkey;
ALTER TABLE public.asignatura_profesor_estudiante
ADD CONSTRAINT asignatura_profesor_estudiante_id_profesor_fkey
FOREIGN KEY (id_profesor) REFERENCES public.profesor (id) ON DELETE CASCADE;
ALTER TABLE public.asignatura_profesor_estudiante DROP CONSTRAINT asignatura_profesor_estudiante_id_estudiante_fkey;
ALTER TABLE public.asignatura_profesor_estudiante
ADD CONSTRAINT asignatura_profesor_estudiante_id_estudiante_fkey
FOREIGN KEY (id_estudiante) REFERENCES public.estudiante (id) ON DELETE CASCADE;

ALTER TABLE public.curso_anno DROP CONSTRAINT curso_anno_id_curso_fkey;
ALTER TABLE public.curso_anno
ADD CONSTRAINT curso_anno_id_curso_fkey
FOREIGN KEY (id_curso) REFERENCES public.curso (id) ON DELETE CASCADE;
ALTER TABLE public.curso_anno DROP CONSTRAINT curso_anno_id_anno_fkey;
ALTER TABLE public.curso_anno
ADD CONSTRAINT curso_anno_id_anno_fkey
FOREIGN KEY (id_anno) REFERENCES public.anno (id) ON DELETE CASCADE;

ALTER TABLE public.facultad_curso DROP CONSTRAINT facultad_curso_id_facultad_fkey;
ALTER TABLE public.facultad_curso
ADD CONSTRAINT facultad_curso_id_facultad_fkey
FOREIGN KEY (id_facultad) REFERENCES public.facultad (id) ON DELETE CASCADE;
ALTER TABLE public.facultad_curso DROP CONSTRAINT facultad_curso_id_curso_fkey;
ALTER TABLE public.facultad_curso
ADD CONSTRAINT facultad_curso_id_curso_fkey
FOREIGN KEY (id_curso) REFERENCES public.curso (id) ON DELETE CASCADE;

ALTER TABLE public.semestre_asignatura DROP CONSTRAINT semestre_asignatura_id_semestre_fkey;
ALTER TABLE public.semestre_asignatura
ADD CONSTRAINT semestre_asignatura_id_semestre_fkey
FOREIGN KEY (id_semestre) REFERENCES public.semestre (id) ON DELETE CASCADE;
ALTER TABLE public.semestre_asignatura DROP CONSTRAINT semestre_asignatura_id_asignatura_fkey;
ALTER TABLE public.semestre_asignatura
ADD CONSTRAINT semestre_asignatura_id_asignatura_fkey
FOREIGN KEY (id_asignatura) REFERENCES public.asignatura (id) ON DELETE CASCADE;

ALTER TABLE public.signature_career DROP CONSTRAINT signature_faculty_career_id_fk;
ALTER TABLE public.signature_career
ADD CONSTRAINT signature_faculty_career_id_fk
FOREIGN KEY (id_career) REFERENCES public.carrera (id) ON DELETE CASCADE;
ALTER TABLE public.signature_career DROP CONSTRAINT signature_faculty_asignatura_id_fk;
ALTER TABLE public.signature_career
ADD CONSTRAINT signature_faculty_asignatura_id_fk
FOREIGN KEY (id_signature) REFERENCES public.asignatura (id) ON DELETE CASCADE;