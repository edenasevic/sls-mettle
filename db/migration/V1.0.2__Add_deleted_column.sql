ALTER TABLE slsmettle.items ADD COLUMN IF NOT EXISTS deleted BOOLEAN DEFAULT FALSE;
