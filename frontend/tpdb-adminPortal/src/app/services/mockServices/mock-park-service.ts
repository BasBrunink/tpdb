import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {Park, ParkStatus, ParkType} from '../../model/park/park.model';
import {DateTime} from 'luxon';

@Injectable({
  providedIn: 'root'
})
export class MockParkService {
  parks: Park[] = [
    {
      id: 'a7a2543b-956e-48a9-be09-bb32a2080075',
      created: DateTime.now(),
      updated: DateTime.now(),
      name: 'Europa-park',
      description: `<p>Europa-Park is sinds 1975 een attractiepark bij Rust in de Duitse deelstaat Baden-Württemberg. Thema is het werelddeel Europa met haar verschillende landen. In 2023 was het na het Disneyland Park in Parijs het best bezochte attractiepark van Europa. Naam en thema van het grootste attractiepark van Duitsland zijn een gevolg van de voorgenomen vestiging aan het meertje 'Europaweiher' die geen doorgang vond.</p>

<p>Het attractiepark is begonnen als 'etalage' om de producten van MACK Rides te tonen en groeide uit tot een resort met zes hotels, een camping en een waterpark. Alle onderdelen zijn met elkaar verbonden door pendelbussen en een monorail. Het attractiepark telt diverse themagebieden die ieder een bepaald Europees land verbeelden. Ook attracties verwijzen naar het desbetreffende land. Qua ontwerp en uitvoering heeft het park zich veelvoudig laten inspireren door het Amerikaanse Disneyland Resort en Walt Disney World Resort. Zowel qua attractie-aanbod als themagebieden zijn er overeenkomsten.</p>`,
      parkType: ParkType.THEMEPARK,
      opening: DateTime.fromObject({
        year: 1975,
        month: 7,
        day: 1
      }),
      closing: null,
      status: ParkStatus.OPERATING,
      address: '',
      areaSize: 0
    },
    {
      id: 'a7a2543b-956e-48a9-be09-bb32a2080076',
      created: DateTime.now(),
      updated: DateTime.now(),
      name: 'Efteling',
      description: `
            <p>De Efteling is een attractiepark en recreatiecomplex in Kaatsheuvel, een dorp in de Nederlandse provincie Noord-Brabant. Naast het attractiepark omvat de hele Wereld van de Efteling een theater (Efteling Theater), drie hotels (Efteling Grand Hotel, Efteling Wonder Hotel en Efteling Loonsche Land Hotel) en twee vakantieparken (Efteling Bosrijk en Efteling Loonsche Land).</p>
            <p>De Efteling is qua bezoekersaantallen en oppervlakte het grootste attractiepark van de Benelux. Het behoort tot de meest bezochte themaparken van Europa en was in 2020, dankzij de coronapandemie, het meest bezochte attractiepark van Europa, hoewel Disneyland Paris (bestaande uit het Disneyland Park en het Walt Disney Studios Park) in totaal wel meer bezoekers aantrok.[6]</p>
            <p>De Efteling is onderscheiden met diverse prijzen, waaronder de Pomme d'Or voor het "beste recreatiepark van Europa" (1972) en de IAAPA Applause Award voor het "beste pretpark ter wereld" (1992). Sinds 1 april 2010 is het park het hele jaar door geopend.</p>
            <p>Hoewel het park aanvankelijk was ingericht voor ouders met kinderen tot circa twaalf jaar, heeft de Efteling zich ontwikkeld tot een themapark voor alle leeftijden. Het is gegroeid van een natuurpark met een sprookjesbos, een speeltuin, roeivijvers en een theehuis tot een attractiepark met diverse achtbanen en darkrides van multinationals als Vekoma, Intamin AG, Bolliger & Mabillard, MACK Rides, ETF Ride Systems en Great Coasters International. Het park is een van de oudste nog geopende themaparken ter wereld: natuurpark de Efteling opende`,
      parkType: ParkType.THEMEPARK,
      opening: DateTime.fromObject({
        year: 1953,
        month: 6,
        day: 1
      }),
      closing: null,
      status: ParkStatus.OPERATING,
      address: '',
      areaSize: 0
    },
    {
      id: 'a7a2543b-956e-48a9-be09-bb32a2080077',
      created: DateTime.now(),
      updated: DateTime.now(),
      name: 'DisneyLand Paris',
      description: `<p>
<strong>Disneyland Paris</strong>, eerder Euro Disney Resort, Euro Disneyland Paris en Disneyland Resort Paris geheten, is een attractiepark- en recreatiecomplex gevestigd in de Franse gemeente Chessy, in het departement Seine-et-Marne.[1] Het park ligt ongeveer 30 kilometer ten oosten van het centrum van de hoofdstad Parijs.
</p>
<p>
Het grootste gedeelte van het complex ligt in de gemeente Chessy en een kleiner gedeelte in de gemeente Coupvray, beide onderdelen van de ville nouvelle (nieuwe stad) Marne-la-Vallée. Disneyland Paris is het vierde Disney-resort ter wereld en bestaat uit diverse onderdelen: twee themaparken (Disneyland Park en het Walt Disney Studios Park), het uitgaansgebied Disney Village, een golfresort, zes Disney Hotels, twee Disney Nature Resorts en een aantal partnerhotels. Alle onderdelen zijn onderling verbonden met een uitgebreid wegennet en diverse gratis buslijnen. Jaarlijks heeft Disneyland Paris het hoogste bezoekersaantal onder de attractieparken in Europa.
</p>
<p>
Het recreatiecomplex werd op 12 april 1992 geopend als Euro Disney Resort. Destijds bestond alleen het eerste attractiepark, dat toen Euro Disneyland heette. In 1994 heette het complex kortstondig Euro Disneyland Paris. Later dat jaar kregen het complex en het attractiepark voor het eerst de naam Disneyland Paris. Op 16 maart 2002 werd de naam van het complex veranderd in Disneyland Resort Paris, tegelijk met de opening van het Walt Disney Studios Park, het tweede attractiepark van het complex. Het eerste park heet sindsdien Disneyland Park. Sinds 2009 is Disneyland Paris opnieuw de naam van het recreatiecomplex.
</p>
`,
      parkType: ParkType.THEMEPARK,
      opening: DateTime.fromObject({year: 1992, month: 6, day: 1}),
      status: ParkStatus.OPERATING,
      address: '',
      areaSize: 0
    }
  ]

  getAllParks(): Observable<Park[]> {
    return of(this.parks)
  }


  constructor() {
  }
}
