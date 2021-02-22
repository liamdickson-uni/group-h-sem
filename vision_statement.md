## Introduction

#### Purpose
The purpose of this application is to enable reporting on population data for the organisation. With the given information it is unclear who the primary user of the system is. So we will assume that everyone will use the system. An existing SQL Database exists with all the data that is required.

#### Solution Overview
The application will allow a user to access a set list of reports and data. This will allow a more efficient summary of population data in order to complete tasks more effectively.

## User Description
We can assume that the application users will have limited technical knowledge. Users require pre-defined reports and data to be easily generated. 

## Features
The following list of reports should be able to be generated;

- All the countries in the world organised by largest population to smallest.
- All the countries in a continent organised by largest population to smallest.
- All the countries in a region organised by largest population to smallest.
- The top `N` populated countries in the world where `N` is provided by the user.
- The top `N` populated countries in a continent where `N` is provided by the user.
- The top `N` populated countries in a region where `N` is provided by the user.
- All the cities in the world organised by largest population to smallest.
- All the cities in a continent organised by largest population to smallest.
- All the cities in a region organised by largest population to smallest.
- All the cities in a country organised by largest population to smallest.
- All the cities in a district organised by largest population to smallest.
- The top `N` populated cities in the world where `N` is provided by the user.
- The top `N` populated cities in a continent where `N` is provided by the user.
- The top `N` populated cities in a region where `N` is provided by the user.
- The top `N` populated cities in a country where `N` is provided by the user.
- The top `N` populated cities in a district where `N` is provided by the user.
- All the capital cities in the world organised by largest population to smallest.
- All the capital cities in a continent organised by largest population to smallest.
- All the capital cities in a region organised by largest to smallest.
- The top `N` populated capital cities in the world  where `N` is provided by the user.
- The top `N` populated capital cities in a continent where `N` is provided by the user.
- The top `N` populated capital cities in a region where `N` is provided by the user.
- The population of people, people living in cities, and people not living in cities in each continent.
- The population of people, people living in cities, and people not living in cities in each region.
- The population of people, people living in cities, and people not living in cities in each country.

Additionally, the following information should be accessible to the organisation:

- The population of the world.
- The population of a continent.
- The population of a region.
- The population of a country.
- The population of a district.
- The population of a city.

Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:

- Chinese.
- English.
- Hindi.
- Spanish.
- Arabic.

Country Report - 
A country report requires the following columns:

- Code.
- Name.
- Continent.
- Region.
- Population.
- Capital.

 City Report - 
A city report requires the following columns:

- Name.
- Country.
- District.
- Population.

Capital City Report - 
A capital city report requires the following columns:

- Name.
- Country.
- Population.

Population Report - 
For the population reports, the following information is requested:

- The name of the continent/region/country.
- The total population of the continent/region/country.
- The total population of the continent/region/country living in cities (including a %).
- The total population of the continent/region/country not living in cities (including a %).
