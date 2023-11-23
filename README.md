# EnergyMarket Kata for AGREGIO
## Overview
Agregio can place offers on 3 markets, each consisting of multiple hourly "blocks" (a day with 24 hours may contain 8 blocks of 3 hours each). Each block specifies the quantity of energy (in MW) to be produced and a minimum price for selling.
Different types of power plants (solar, wind, or hydro) can provide a certain number of megawatts during a block.

##APIs
This code implements 4 Apis defined by the following endpoints:
1. **Create Offer API:**
   - Endpoint: `/offers`
   - Method: POST

2. **Create Power Plant API:**
   - Endpoint: `/plants`
   - Method: POST

3. **List Offers for a market API:**
   - Endpoint: `/offers/{market}`
   - Method: GET

4. **List Power Plants that sell for a Market  API:**
   - Endpoint: `/plants/{market}`
   - Method: GET
## Note
Due to the time constraint, the solution might not be fully complete, but it reflects the development approach and considerations made during the allotted time:  
- Exception handling was not taken into consideration.  
- Unit Test cover only Services and Controllers.  
- The following assumption was made regarding the database model: In each offer block, only one plant is involved.  


