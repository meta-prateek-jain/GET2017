import { InMemoryDbService } from 'angular-in-memory-web-api';
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const products = [
      { id: 0, name: "Zero", price: 0 },
      { id: 1, name: "Puma T-shirts", price: 12909 },
      { id: 2, name: "Wrangler jeans", price: 1970 },
      { id: 3, name: "HP Laptop", price: 54399 },
      { id: 4, name: "Earphones", price: 250 },
      { id: 5, name: "Levis Shirt", price: 3500 },
      { id: 6, name: "Compaq Desktop", price: 10500 },
      { id: 7, name: "JBL Speakers", price: 2300 },
      { id: 8, name: "Philips Trimmer", price: 850 },
      { id: 9, name: "SD Card", price: 340 },
      { id: 10, name: "Speakers", price: 2300 },
      { id: 11, name: "Microphone", price: 199 }
    ];
    return { products };
  }
}
