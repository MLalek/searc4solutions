@smoke @sollicitatieForm
Feature: US001 Solliciteren bij search4solutions

  Background:
    Given I am on the search4solutions home page

  Scenario Outline: TC01 Apply for cloud eng position <test_case> <message>
    And I am on the 'Cloud Engineer' job application form
    And I want to apply for Cloud Engineer position <test_case>

    When I send following attributes to apply for the Cloud Engineer position:
      | firstName   | lastName   | e-mail   | telefoonNummer   | linkedInUrl   | motivatie   |
      | <firstName> | <lastName> | <e-mail> | <telefoonNummer> | <linkedInUrl> | <motivatie> |

    Then I should see '<message>' on the page

    And user hover over Werken bij on the menu
    And user choose Cloud Engineer
    When user click to button Solliciteren
    And user fills out the form first name "<firstName>"
    And user fills out the form last name "<lastName>"
    And user fills out the form e-mail "<e-mail>"
    And user fills out the form Telefoonnummer "<telefoonNummer>"

    And user send the filled form
    Then verify that the form is sent

    Examples:form positive scenario
      | test_case               | message                                        | firstName | lastName | e-mail       | telefoonNummer |
      | WITHOUT NAME            | Naam is missing required subfields: First Name |           | Sade     | nemo@sade.nl | +31612345678   |
      | WITH INVALID NAME - /*  | Naam: First Name is not valid.                 | /*        | Sade     | nemo@sade.nl | abc            |
      | WITH INVALID NAME - a   | Naam: First Name is not valid.                 | a         | Sade     | nemo@sade.nl | abc            |
      | WITHOUT E-MAIL          | E-mail is required.                            | Nemo      | Sade     |              | abc            |
      | WIT ALL REQUIRED FIELDS | Dankjewel voor je sollicitatie!                | Nemo      | Sade     | nemo@sade.nl | abc            |


  Scenario Outline: TC02 Verifieren voor sollicitatie form -Negative


    Then user gets the result of the application
    And user hover over Werken bij on the menu
    And user choose Cloud Engineer
    When user click to button Solliciteren
    And user fills out the form with not valid first name "<firstName>"
    And user fills out the form with not valid last name "<lastName>"

    And user fills out the form with not valid e-mail "<e-mail>"
    And user fills out the form with not valid Telefoonnummer "<telefoonNummer>"




    Examples:form negative scenario
      | firstName | lastName | e-mail        | telefoonNummer |
      | Nemo      |          | nemosade.nl   | +31612345678   |
      |           | Sade     | nemo@.nl      | +31612345678   |
      | /*        | Sade     | @sade.nl      | +31612345678   |
      | !         | `        | nemo@sadenl   | +31612345678   |
      | Nemo      | Sade     | nemo@sade     | +31612345678   |
      | Nemo      | Sade     | nemo@sade.    | +31612345678   |
      | Nemo      | Sade     | n@n@s.nl      | +31612345678   |
      | Nemo      | Sade     | @nemo@sade.nl | +31612345678   |
      | Nemo      | Sade     | nn@s..nl      | +31612345678   |
      | Nemo      | Sade     | nemo@sade.n   | +31612345678   |
