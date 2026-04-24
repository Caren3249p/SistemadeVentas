import { Heroe } from "../../../domain/entities/Heroe";
import { IHeroRepository } from "../../repositories/IHeroRepository";

export class ObtenerHeroes {
  constructor(private heroRepository: IHeroRepository) {}

  async ejecutar(): Promise<Heroe[]> {
    return await this.heroRepository.findAll();
  }
}