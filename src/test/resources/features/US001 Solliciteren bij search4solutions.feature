@smoke @sollicitatieForm
Feature: US001 Apply for a job at search4solutions

  Background:
    Given I am on the Cloud Engineer job application form

  Scenario Outline: TC01 Apply for cloud engineer position <test_case> should display <message>
    And I want to apply for Cloud Engineer position '<test_case>'

    When I send following attributes to apply for the Cloud Engineer position:
      | firstName   | lastName   | e-mail   | telefoonNummer   |
      | <firstName> | <lastName> | <e-mail> | <telefoonNummer> |

    Then I should see '<message>' on the page


    Examples:
      | test_case                | message                                        | firstName | lastName | e-mail       | telefoonNummer |
      | WITHOUT NAME             | Naam is missing required subfields: First Name | [blank]   | Sade     | nemo@sade.nl | +31612345678   |
      | WITH INVALID NAME - /*   | Naam: First Name is not valid.                 | /*        | Sade     | nemo@sade.nl | abc            |
      | WITH INVALID NAME - a    | Naam: First Name is not valid.                 | a         | Sade     | nemo@sade.nl | abc            |
      | WITHOUT E-MAIL           | E-mail is required.                            | Nemo      | Sade     | [blank]      | abc            |
      | WITH ALL REQUIRED FIELDS | Dankjewel voor je sollicitatie!                | Nemo      | Sade     | nemo@sade.nl | abc            |



