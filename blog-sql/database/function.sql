use blog;

DROP FUNCTION IF EXISTS DATEADD;

CREATE FUNCTION DATEADD (time_diff BIGINT, time_base TIMESTAMP) RETURNS TIMESTAMP
RETURN DATE_ADD(time_base, INTERVAL time_diff SECOND);