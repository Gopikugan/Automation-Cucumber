Feature: Validate SCCI functionality
	Description: This feature will do the regression test for Project Version 2.3
Background: Lead was created
	Given User logged to salesforce Application with username and password
	And User create new lead

@SCCI_Dummy_Demo
Scenario: Verify all necessary options are available for selection
	And User convert this lead
	And User navigates to oppurtunity page
	And User navigatess to new sales engagement page
	When User selects below record Type
	| Record Type |
	| Legal       |
	Then Below Sales Engagement Group and Request Type combination should be available for selection
	| Sales Engagement Group | Request Type                          |
	| Legal - Direct         | Dispute or Claims - Direct            |
	| Legal - Direct         | Sales Contract                        |
	| Legal - Direct         | Existing Customer – General Advice-D  |
	| Legal - Direct         | Procurement - Direct Sales Related    |
	| Legal - Direct         | NDA-D                                 |
	| Legal - Direct         | Procurement - VMB Supplier            |
	| Legal - Direct         | Public Sector Tender                  |
	| Legal - Wholesale      | Dispute or Claims - Wholesale         |
	| Legal - Wholesale      | Sales Contract - Wholesale            |
	| Legal - Wholesale      | Existing Customer – General Advice-W  |
	| Legal - Wholesale      | Procurement - Wholesale Sales Related |
	| Legal - Wholesale      | NDA-W                                 |
	| Legal - Wholesale      | Interconnect Procurement              |
	| Legal - Wholesale      | Dark Fibre Sales Contract             |
	And User creates sales engagement with below details
	| Sales Engagement Group | Request Type |
	| Legal - Direct         | NDA-D        |



@SCCI_Dummy_Demo
Scenario Outline: Verify user able to create sales engagement
	And User convert this lead
	And User navigates to oppurtunity page
	And User navigatess to new sales engagement page
	When User selects "<record Type>" for sales engagement
	Then User creates with "<Sales Engagement Group>" and "<Request Type>" combination
Examples:
	| Record Type	| Sales Engagement Group | Request Type                          |
	| Legal1       	| Legal - Direct         | Dispute or Claims - Direct            |
	| Legal2       	| Legal - Direct         | Sales Contract                        |
	| Legal3       	| Legal - Direct         | Existing Customer – General Advice-D  |
	| Legal4       	| Legal - Direct         | Procurement - Direct Sales Related    |
	| Legal5       	| Legal - Direct         | NDA-D                                 |
	| Legal6       	| Legal - Direct         | Procurement - VMB Supplier            |
	| Legal7       	| Legal - Direct         | Public Sector Tender                  |
	| Legal8       	| Legal - Wholesale      | Dispute or Claims - Wholesale         |
	| Legal9       	| Legal - Wholesale      | Sales Contract - Wholesale            |
	| Legal10      	| Legal - Wholesale      | Existing Customer – General Advice-W  |
	| Legal11      	| Legal - Wholesale      | Procurement - Wholesale Sales Related |
	| Legal12      	| Legal - Wholesale      | NDA-W                                 |
	| Legal13      	| Legal - Wholesale      | Interconnect Procurement              |
	| Legal14      	| Legal - Wholesale      | Dark Fibre Sales Contract             |
