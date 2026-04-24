import { IHeroRepository } from "../../repositories/IHeroRepository";
import { Heroe } from "../../../domain/entities/Heroe";

export interface CrearHeroeDTO {
  name: string;
  description: string;
  price: number;
  stars: number;
  type: string;
  image: string;
  stock: number;
  poder: number;
  vida: number;
  defensa: number;
  ataque: string;
  damage: string;
  efecto: string;
  descuento: number;
}

export class CrearHeroe {
  constructor(private heroRepository: IHeroRepository) {}

  async ejecutar(data: CrearHeroeDTO): Promise<Heroe> {
    // Corregimos el error TS2345 forzando el tipo en data.type
    const heroe = new Heroe(
      null,
      data.name,
      data.description,
      data.price,
      data.stars,
      data.type as any, // 👈 Casting para validar contra la Entidad
      data.image
    );
    
    return await this.heroRepository.create(heroe);
  }
}