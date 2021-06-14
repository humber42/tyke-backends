CREATE TABLE public.signature_faculty
(
    id bigserial PRIMARY KEY,
    id_faculty int,
    id_signature int,
    CONSTRAINT signature_faculty_asignatura_id_fk FOREIGN KEY (id_signature) REFERENCES public.asignatura (id),
    CONSTRAINT signature_faculty_facultad_id_fk FOREIGN KEY (id_faculty) REFERENCES public.facultad (id)
);