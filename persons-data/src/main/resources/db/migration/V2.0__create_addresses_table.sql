CREATE TABLE IF NOT EXISTS addresses (
    id uuid DEFAULT uuid_generate_v4 (),
    person_id uuid NOT NULL,
    postal_code VARCHAR NULL,
    street_name VARCHAR NULL,
    street_number VARCHAR NULL,
    complement VARCHAR NULL,
    neighborhood VARCHAR NULL,
    city VARCHAR NULL,
    state VARCHAR NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_persons FOREIGN KEY(person_id) REFERENCES persons(id)
);