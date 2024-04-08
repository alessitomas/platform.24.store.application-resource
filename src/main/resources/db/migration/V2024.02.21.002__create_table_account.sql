CREATE TABLE inscricao
(
    id_inscricao character varying(36) NOT NULL,
    tx_id_user character varying(36) NOT NULL,
    tx_id_job character varying(36) NOT NULL,
    tx_status character varying(36) NOT NULL,
    CONSTRAINT inscricao_pkey PRIMARY KEY (id_inscricao)
);
