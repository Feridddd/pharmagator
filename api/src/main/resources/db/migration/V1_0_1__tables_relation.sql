ALTER TABLE prices ADD CONSTRAINT pharmacy_id FOREIGN KEY (pharmacy_id) REFERENCES pharmacies (id);
ALTER TABLE prices ADD CONSTRAINT medicine_id FOREIGN KEY (medicine_id) REFERENCES medicines (id);