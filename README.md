# upgrade-api-challenge
test framework for api

The api test framework has tests to validate: 
1. Total state count is 48
2. Validate only one state has a min age of 19, and output the name of that state
3. Validate that Georgia is the only state with min loan amount requirement of $3,005

I wasnt able to complete the test for validating all the state names, but the idea is that I would loop through the states array list and run a regex match to check if each state object label was [A-Z]{2}
