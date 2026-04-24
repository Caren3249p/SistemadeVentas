import { IHeroRepository } from "../../repositories/IHeroRepository";

export class ObtenerHeroePorId {
  constructor(private heroRepository: IHeroRepository) {}

  async ejecutar(id: string | number) { 
    // Manejamos ambos tipos para mayor robustez
    const idNumber = typeof id === 'string' ? parseInt(id) : id;
    
    if (isNaN(idNumber)) {
      throw new Error("ID inválido");
    }

    const hero = await this.heroRepository.findById(idNumber);
    
    if (!hero) {
      throw new Error("Héroe no encontrado");
    }
    
    return hero;
  }
}