-- Insert some flights
INSERT INTO flight (flight_number, origin, destination, departure_time, seats_available)
VALUES 
('AI101', 'Delhi', 'Mumbai', '2025-08-10T09:00:00', 100),
('AI202', 'Bangalore', 'Hyderabad', '2025-08-11T12:30:00', 80),
('AI303', 'Chennai', 'Kolkata', '2025-08-12T17:15:00', 60);

-- Insert some reservations (ensure flight IDs match above inserted flights)
INSERT INTO reservation (passenger_name, seats_booked, reserved_at, flight_id)
VALUES 
('John Doe', 2, '2025-08-05T10:00:00', 1),
('Alice Smith', 1, '2025-08-05T11:00:00', 2);
