-- Insert teammates
INSERT INTO teammate (name, daily_orders, monthly_orders, photo_url)
VALUES
    ('Raju Reddy', 12, 55, 'https://i.pravatar.cc/150?img=1'),
    ('Anjali Sharma', 8, 42, 'https://i.pravatar.cc/150?img=2'),
    ('Karthik Rao', 15, 60, 'https://i.pravatar.cc/150?img=3'),
    ('Meena Iyer', 5, 28, 'https://i.pravatar.cc/150?img=4'),
    ('Arun Verma', 10, 38, 'https://i.pravatar.cc/150?img=5');

-- Insert sample order history
INSERT INTO order_history (teammate_id, teammate_name, daily_orders, monthly_orders, date)
VALUES
    (1, 'Raju Reddy', 20, 50, '2025-09-13'),
    (2, 'Anjali Sharma', 10, 40, '2025-09-13'),
    (3, 'Karthik Rao', 15, 55, '2025-09-13'),
    (1, 'Raju Reddy', 12, 55, '2025-09-14'),
    (2, 'Anjali Sharma', 8, 42, '2025-09-14'),
    (3, 'Karthik Rao', 15, 60, '2025-09-14');
