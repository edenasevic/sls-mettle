CREATE TABLE IF NOT EXISTS slsmettle.items
(
    id          varchar(255)     NOT NULL,
    name        varchar(255)     NOT NULL,
    description varchar(255)     NOT NULL,
    item_type   integer          NOT NULL,
    cost        double precision NOT NULL,
    created_at  timestamp        NOT NULL,
    updated_at  timestamp        NULL,
    deleted_at  timestamp        NULL,
    CONSTRAINT  item_pley        PRIMARY KEY (id)

);
