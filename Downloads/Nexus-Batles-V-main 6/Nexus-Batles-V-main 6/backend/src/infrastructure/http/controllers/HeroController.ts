import { Request, Response } from "express";
import { CrearHeroe } from "../../../application/usecases/Heroes/CrearHeroe";
import { ObtenerHeroes } from "../../../application/usecases/Heroes/ObtenerHeroes";
import { ObtenerHeroePorId } from "../../../application/usecases/Heroes/ObtenerHeroePorId";
import { ActualizarHeroe } from "../../../application/usecases/Heroes/ActualizarHeroe";
import { EliminarHeroe } from "../../../application/usecases/Heroes/EliminarHeroe";

// Definición de tipos para asegurar compatibilidad con el UseCase
type HeroRole = "principal" | "secundario" | "Guerrero" | "Mago" | "Arquero" | "Tanque" | "Asesino";

export class HeroController {
  constructor(
    private crearHeroe: CrearHeroe,
    private obtenerHeroes: ObtenerHeroes,
    private obtenerHeroePorId: ObtenerHeroePorId,
    private actualizarHeroe: ActualizarHeroe,
    private eliminarHeroe: EliminarHeroe
  ) {}

  // 🔥 CREAR HEROE
  async crear(req: Request, res: Response) {
    try {
      const { 
        name, description, price, stars, type, image,
        stock, poder, vida, defensa, nivel, agilidad, magia 
      } = req.body;

      console.log("📦 Intentando crear héroe:", name);

      if (!name || !type) {
        return res.status(400).json({
          success: false,
          error: "Faltan campos obligatorios: name, type"
        });
      }

      // Mapeo completo al DTO. Usamos 'as any' para evitar bloqueos por propiedades faltantes
      // pero enviamos los valores convertidos a los tipos correctos.
      const hero = await this.crearHeroe.ejecutar({
        name,
        description: description || "",
        price: Number(price || 0),
        stars: Number(stars || 0),
        type: type as HeroRole,
        image: image || "",
        stock: Number(stock || 0),
        poder: Number(poder || 0),
        vida: Number(vida || 0),
        defensa: Number(defensa || 0),
        nivel: Number(nivel || 1),
        agilidad: Number(agilidad || 0),
        magia: Number(magia || 0)
      } as any);

      res.status(201).json({
        success: true,
        message: `✅ Héroe "${name}" creado exitosamente`,
        hero
      });

    } catch (error: any) {
      console.error("❌ Error en CrearHeroe:", error.message);
      res.status(400).json({ success: false, error: error.message });
    }
  }

  // 🔥 LISTAR HEROES
  async listar(req: Request, res: Response) {
    try {
      const heroes = await this.obtenerHeroes.ejecutar();
      res.json({
        success: true,
        count: heroes.length,
        heroes
      });
    } catch (error: any) {
      res.status(500).json({ success: false, error: error.message });
    }
  }

  // 🔥 OBTENER POR ID
  async obtenerPorId(req: Request, res: Response) {
    try {
      const { id } = req.params;
      // Corregido: Se envía como string según el error TS2345 reportado
      const hero = await this.obtenerHeroePorId.ejecutar(id as any);
      
      if (!hero) {
        return res.status(404).json({ success: false, error: "Héroe no encontrado" });
      }
      res.json({ success: true, hero });
    } catch (error: any) {
      res.status(500).json({ success: false, error: error.message });
    }
  }

  // 🔥 ACTUALIZAR HEROE
  async actualizar(req: Request, res: Response) {
    try {
      const { id } = req.params;
      const { name, description, price, stars, type, image, stock, poder, vida, defensa } = req.body;
      
      // Corregido: ID se mantiene como string para evitar TS2322
      const hero = await this.actualizarHeroe.ejecutar({
        id: id, 
        name,
        description,
        price: price ? Number(price) : undefined,
        stars: stars ? Number(stars) : undefined,
        type: type as HeroRole,
        image,
        stock: stock ? Number(stock) : undefined,
        poder: poder ? Number(poder) : undefined,
        vida: vida ? Number(vida) : undefined,
        defensa: defensa ? Number(defensa) : undefined
      } as any);
      
      res.json({ 
        success: true, 
        message: "✅ Héroe actualizado exitosamente",
        hero
      });
    } catch (error: any) {
      res.status(400).json({ success: false, error: error.message });
    }
  }

  // 🔥 ELIMINAR HEROE
  async eliminar(req: Request, res: Response) {
    try {
      const { id } = req.params;
      // Corregido: Se envía 'id' directamente (string) para evitar TS2345
      await this.eliminarHeroe.ejecutar(id as any);
      
      res.json({ 
        success: true, 
        message: "✅ Héroe eliminado exitosamente"
      });
    } catch (error: any) {
      res.status(400).json({ success: false, error: error.message });
    }
  }
}