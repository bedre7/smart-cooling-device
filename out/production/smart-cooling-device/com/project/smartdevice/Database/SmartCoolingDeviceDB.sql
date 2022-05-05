--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2022-05-04 16:54:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3315 (class 1262 OID 17411)
-- Name: smart-cooling-device; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "smart-cooling-device" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.utf8';


ALTER DATABASE "smart-cooling-device" OWNER TO postgres;

\connect -reuse-previous=on "dbname='smart-cooling-device'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3309 (class 0 OID 17413)
-- Dependencies: 210
-- Data for Name: User; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."User" (id, username, password) VALUES (1, 'bedru', '1234');
INSERT INTO public."User" (id, username, password) VALUES (3, 'kante', '5647');
INSERT INTO public."User" (id, username, password) VALUES (5, 'Pr.celal', '12345');
INSERT INTO public."User" (id, username, password) VALUES (6, 'fatih', '12345');


--
-- TOC entry 3317 (class 0 OID 0)
-- Dependencies: 209
-- Name: User_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."User_id_seq"', 6, true);


-- Completed on 2022-05-04 16:54:43

--
-- PostgreSQL database dump complete
--

