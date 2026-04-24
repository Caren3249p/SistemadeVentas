import mysql from 'mysql2/promise';
import { env } from '../../config/env';
import { logger } from '../logging/logger';

export const pool = mysql.createPool({
  host: env.DB_HOST,
  port: env.DB_PORT,
  user: env.DB_USER,
  password: env.DB_PASSWORD,
  database: env.DB_NAME,
  waitForConnections: true,
  connectionLimit: 10,
  queueLimit: 0,
});

export async function testConnection(): Promise<void> {
  try {
    const connection = await pool.getConnection();
    logger.info('[DB] Conexión a MySQL establecida correctamente');
    connection.release();
  } catch (error) {
    logger.error('[DB] Error al conectar con MySQL', { error });
    throw error;
  }
}

export default pool;