# launchdarkly_hw

This is a sample Java server-side program.

The logic simulates a user logging into a particular environment to view a pricelist.
The feature flag mic-check controls users' ability to see pricelist details. 
In the Test environment, everyone can see details as fake/test data is used. Access is restricted
to the Finance Director segmenet (i.e. anna) for Production.

Link the LaunchDarkly SDK via Gradle and run Main to get started.
