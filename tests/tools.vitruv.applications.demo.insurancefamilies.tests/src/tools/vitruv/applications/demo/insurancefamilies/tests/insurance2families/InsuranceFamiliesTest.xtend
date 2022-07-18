package tools.vitruv.applications.demo.insurancefamilies.tests.insurance2families

import edu.kit.ipd.sdq.metamodels.insurance.Gender
import edu.kit.ipd.sdq.metamodels.insurance.InsuranceClient
import edu.kit.ipd.sdq.metamodels.insurance.InsuranceFactory
import java.util.ArrayList
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.assertEquals
import static tools.vitruv.applications.demo.insurancefamilies.tests.util.FamiliesQueryUtil.claimFamily
import static tools.vitruv.applications.demo.insurancefamilies.tests.util.FamiliesQueryUtil.claimFamilyRegister
import static tools.vitruv.applications.demo.insurancefamilies.tests.util.InsuranceQueryUtil.claimInsuranceClient
import static tools.vitruv.applications.demo.insurancefamilies.tests.util.InsuranceQueryUtil.claimInsuranceDatabase

class InsuranceFamiliesTest extends AbstractInsuranceFamiliesTest {	
	
	// === TESTS: InsuranceDatabase ===
	
	@Test
	def void testCreateInsuranceDatabase() {
		changeInsuranceView[
			var insuranceDatabase = InsuranceFactory.eINSTANCE.createInsuranceDatabase
			createAndRegisterRoot(insuranceDatabase,  getProjectModelPath("insurance", INSURANCE_MODEL_FILE_EXTENSION).uri)
		]
		
		validateFamilyView [
			assertEquals(1, it.getRootObjects().size)
			assertNumberOfFamilies(0)
		]
	}
	
	def void testDeleteInsuranceDatabase() {
		createEmptyInsuranceDatabase()
		
		changeInsuranceView[
			var insuranceDatabase = claimInsuranceDatabase(it)
			deleteAndUnregisterRoot(insuranceDatabase)
		]
		
		validateFamilyView[
			assertEquals(0, it.getRootObjects().size)
		]
	}
	
	// === TESTS: Client ===
	
	@Test
	def void testCreatedClient_father(){
		createEmptyInsuranceDatabase();
		
		decideParentOrChild(PositionPreference.Parent)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_DAD_1, LAST_NAME_1) gender = Gender.MALE]
			]
		]
		
		val expectedFamily = createFamily [
				lastName = LAST_NAME_1
				father = createFamilyMember [ firstName = FIRST_DAD_1]
			]
		validateFamilyView [
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testCreatedClient_mother(){
		createEmptyInsuranceDatabase();
		
		decideParentOrChild(PositionPreference.Parent)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_MOM_1, LAST_NAME_1) gender = Gender.FEMALE]
			]
		]
		
		val expectedFamily = createFamily [
				lastName = LAST_NAME_1
				mother = createFamilyMember [ firstName = FIRST_MOM_1]
			]
		validateFamilyView [
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testCreatedClient_son(){
		createEmptyInsuranceDatabase();
		
		decideParentOrChild(PositionPreference.Child)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_SON_1, LAST_NAME_1) gender = Gender.MALE]
			]
		]
		
		val expectedFamily = createFamily [
				lastName = LAST_NAME_1
				sons += createFamilyMember [ firstName = FIRST_SON_1]
			]
		validateFamilyView [
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testCreatedClient_dauther(){
		createEmptyInsuranceDatabase();
		
		decideParentOrChild(PositionPreference.Child)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_DAU_1, LAST_NAME_1) gender = Gender.FEMALE]
			]
		]
		
		val expectedFamily = createFamily [
				lastName = LAST_NAME_1
				daughters += createFamilyMember [ firstName = FIRST_DAU_1]
			]
		validateFamilyView [
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testCreatedClient_addMultipleToExistingFamily(){
		createEmptyInsuranceDatabase();
		
		decideParentOrChild(PositionPreference.Parent)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_DAD_1, LAST_NAME_1) gender = Gender.MALE]
			]
		]
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.Existing, 1)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_MOM_1, LAST_NAME_1) gender = Gender.FEMALE]
			]
		]
		decideParentOrChild(PositionPreference.Child)
		decideNewOrExistingFamily(FamilyPreference.Existing, 1)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_SON_1, LAST_NAME_1) gender = Gender.MALE]
			]
		]
		decideParentOrChild(PositionPreference.Child)
		decideNewOrExistingFamily(FamilyPreference.Existing, 1)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_SON_2, LAST_NAME_1) gender = Gender.MALE]
			]
		]
		decideParentOrChild(PositionPreference.Child)
		decideNewOrExistingFamily(FamilyPreference.Existing, 1)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_DAU_1, LAST_NAME_1) gender = Gender.FEMALE]
			]
		]
		decideParentOrChild(PositionPreference.Child)
		decideNewOrExistingFamily(FamilyPreference.Existing, 1)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_DAU_2, LAST_NAME_1) gender = Gender.FEMALE]
			]
		]
		
		val expectedFamily = createFamily [
				lastName = LAST_NAME_1
				father = createFamilyMember [ firstName = FIRST_DAD_1]
				mother = createFamilyMember [ firstName = FIRST_MOM_1]
				sons += createFamilyMember [ firstName = FIRST_SON_1]
				sons += createFamilyMember [ firstName = FIRST_SON_2]
				daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				daughters += createFamilyMember [ firstName = FIRST_DAU_2]
			]
		validateFamilyView [
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testCreatedClient_fatherNewFamily(){
		createInsuranceDatabaseWithCompleteFamily();
		
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.New, 0)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_DAD_2, LAST_NAME_1) gender = Gender.MALE]
			]
		]
		
		val expectedFamily1 = COMPLETE_FAMILY_1
		val expectedFamily2 = createFamily [
			lastName = LAST_NAME_1
			father = createFamilyMember [ firstName = FIRST_DAD_2 ]
		]
		validateFamilyView [
			var families = claimFamilyRegister(it).families
			assertNumberOfFamilies(2)
			
			assertFamily(expectedFamily1, families.get(0))
			assertFamily(expectedFamily2, families.get(1))
		]
	}
	
	@Test
	def void testCreatedClient_motherNewFamily(){
		createInsuranceDatabaseWithCompleteFamily();
		
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.New, 0)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_MOM_2, LAST_NAME_1) gender = Gender.FEMALE]
			]
		]
		
		val expectedFamily1 = COMPLETE_FAMILY_1
		val expectedFamily2 = createFamily [
			lastName = LAST_NAME_1
			mother = createFamilyMember [ firstName = FIRST_MOM_2 ]
		]
		validateFamilyView [
			var families = claimFamilyRegister(it).families
			assertNumberOfFamilies(2)
			assertFamily(expectedFamily1, families.get(0))
			assertFamily(expectedFamily2, families.get(1))
		]
	}
	
	@Test
	def void testCreatedClient_sonNewFamily(){
		createInsuranceDatabaseWithCompleteFamily();
		
		decideParentOrChild(PositionPreference.Child)
		decideNewOrExistingFamily(FamilyPreference.New, 0)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_SON_2, LAST_NAME_1) gender = Gender.MALE]
			]
		]
		
		val expectedFamily1 = COMPLETE_FAMILY_1
		val expectedFamily2 = createFamily [
			lastName = LAST_NAME_1
			sons += createFamilyMember [ firstName = FIRST_SON_2 ]
		]
		validateFamilyView [
			var families = claimFamilyRegister(it).families
			assertNumberOfFamilies(2)
			assertFamily(expectedFamily1, families.get(0))
			assertFamily(expectedFamily2, families.get(1))
		]
	}
	
	@Test
	def void testCreatedClient_daugtherNewFamily(){
		createInsuranceDatabaseWithCompleteFamily();
		
		decideParentOrChild(PositionPreference.Child)
		decideNewOrExistingFamily(FamilyPreference.New, 0)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_DAU_2, LAST_NAME_1) gender = Gender.FEMALE]
			]
		]
		
		val expectedFamily1 = COMPLETE_FAMILY_1
		val expectedFamily2 = createFamily [
			lastName = LAST_NAME_1
			daughters += createFamilyMember [ firstName = FIRST_DAU_2 ]
		]
		validateFamilyView [
			var families = claimFamilyRegister(it).families
			assertNumberOfFamilies(2)
			
			assertFamily(expectedFamily1, families.get(0))
			assertFamily(expectedFamily2, families.get(1))
		]
	}
	
	@Test
	def void testCreatedClient_fatherExistingFamilyBlocked(){
		createInsuranceDatabaseWithCompleteFamily();
		
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.Existing, 1)
		awaitReplacementInformation(fullName(FIRST_DAD_1, LAST_NAME_1), LAST_NAME_1)
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.New, 0)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_DAD_2, LAST_NAME_1) gender = Gender.MALE]
			]
		]
		
		val expectedFamily1 = createFamily [
			lastName = LAST_NAME_1
			father = createFamilyMember [ firstName = FIRST_DAD_2]
			mother = createFamilyMember [ firstName = FIRST_MOM_1]
			sons += createFamilyMember [ firstName = FIRST_SON_1]
			daughters += createFamilyMember [ firstName = FIRST_DAU_1]
		]
		val expectedFamily2 = createFamily [
			lastName = LAST_NAME_1
			father = createFamilyMember [ firstName = FIRST_DAD_1 ]
		]
		validateFamilyView [
			var families = claimFamilyRegister(it).families
			assertNumberOfFamilies(2)
			assertFamily(expectedFamily1, families.get(0))
			assertFamily(expectedFamily2, families.get(1))
		]
	}
	
	@Test
	def void testCreatedClient_motherExistingFamilyBlocked(){
		createInsuranceDatabaseWithCompleteFamily();
		
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.Existing, 1)
		awaitReplacementInformation(fullName(FIRST_MOM_1, LAST_NAME_1), LAST_NAME_1)
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.New, 0)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient += createInsuranceClient [name = fullName(FIRST_MOM_2, LAST_NAME_1) gender = Gender.FEMALE]
			]
		]
		
		val expectedFamily1 = createFamily [
			lastName = LAST_NAME_1
			father = createFamilyMember [ firstName = FIRST_DAD_1]
			mother = createFamilyMember [ firstName = FIRST_MOM_2]
			sons += createFamilyMember [ firstName = FIRST_SON_1]
			daughters += createFamilyMember [ firstName = FIRST_DAU_1]
		]
		val expectedFamily2 = createFamily [
			lastName = LAST_NAME_1
			mother = createFamilyMember [ firstName = FIRST_MOM_1 ]
		]
		validateFamilyView [
			var families = claimFamilyRegister(it).families
			assertNumberOfFamilies(2)
			
			assertFamily(expectedFamily1, families.get(0))
			assertFamily(expectedFamily2, families.get(1))
		]
	}
	
	@Test
	def void testDeleteClient_father(){
		createInsuranceDatabaseWithCompleteFamily();
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient -= insuranceclient.findFirst[client | client.name == fullName(FIRST_DAD_1, LAST_NAME_1)]
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					mother = createFamilyMember [ firstName = FIRST_MOM_1]
					sons += createFamilyMember [ firstName = FIRST_SON_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testDeleteClient_mother(){
		createInsuranceDatabaseWithCompleteFamily();
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient -= insuranceclient.findFirst[client | client.name == fullName(FIRST_MOM_1, LAST_NAME_1)]
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_DAD_1]
					sons += createFamilyMember [ firstName = FIRST_SON_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testDeleteClient_son(){
		createInsuranceDatabaseWithCompleteFamily()
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient -= insuranceclient.findFirst[client | client.name == fullName(FIRST_SON_1, LAST_NAME_1)]
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_DAD_1]
					mother = createFamilyMember [ firstName = FIRST_MOM_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testDeleteClient_daughter(){
		createInsuranceDatabaseWithCompleteFamily()
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				insuranceclient -= insuranceclient.findFirst[client | client.name == fullName(FIRST_DAU_1, LAST_NAME_1)]
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_DAD_1]
					mother = createFamilyMember [ firstName = FIRST_MOM_1]
					sons += createFamilyMember [ firstName = FIRST_SON_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testDeleteClient_deleteFamilyIfEmpty(){
		createInsuranceDatabaseWithCompleteFamily()
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				var existingClients = new ArrayList<InsuranceClient>(insuranceclient)
				for(existingClient : existingClients){
					insuranceclient -= existingClient
				}
			]
		]
		
		validateFamilyView [
			assertNumberOfFamilies(0)
		]
	}
	
	@Test
	def void testChangeGender_MotherToFather(){
		createInsuranceDataBaseWithOptionalCompleteFamily(false, true, true, true)
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_MOM_1, LAST_NAME_1).gender = Gender.MALE
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_MOM_1]
					sons += createFamilyMember [ firstName = FIRST_SON_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testChangeGender_FatherToMother(){
		createInsuranceDataBaseWithOptionalCompleteFamily(true, false, true, true)
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_DAD_1, LAST_NAME_1).gender = Gender.FEMALE
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					mother = createFamilyMember [ firstName = FIRST_DAD_1]
					sons += createFamilyMember [ firstName = FIRST_SON_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testChangeGender_DaugtherToSon(){
		createInsuranceDataBaseWithOptionalCompleteFamily(true, true, true, true)
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_DAU_1, LAST_NAME_1).gender = Gender.MALE
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_DAD_1]
					mother = createFamilyMember [ firstName = FIRST_MOM_1]
					sons += createFamilyMember [ firstName = FIRST_SON_1]
					sons += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testChangeGender_SonToDaughter(){
		createInsuranceDataBaseWithOptionalCompleteFamily(true, true, true, true)
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_SON_1, LAST_NAME_1).gender = Gender.FEMALE
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_DAD_1]
					mother = createFamilyMember [ firstName = FIRST_MOM_1]
					daughters += createFamilyMember [ firstName = FIRST_SON_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testChangeGender_MotherToFatherBlocked(){
		createInsuranceDatabaseWithCompleteFamily()
		
		awaitReplacementInformation(fullName(FIRST_DAD_1, LAST_NAME_1), LAST_NAME_1)
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.New, 0)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_MOM_1, LAST_NAME_1).gender = Gender.MALE
			]
		]
		
		validateFamilyView [
			var expectedFamily1 = createFamily [
				lastName = LAST_NAME_1
				father = createFamilyMember [ firstName = FIRST_MOM_1]
				sons += createFamilyMember [ firstName = FIRST_SON_1]
				daughters += createFamilyMember [ firstName = FIRST_DAU_1]
			]
			var expectedFamily2 = createFamily [
				lastName = LAST_NAME_1
				father = createFamilyMember [ firstName = FIRST_DAD_1]
			]
			
			var families = claimFamilyRegister(it).families
			assertNumberOfFamilies(2)
			var family1 = families.get(0)
			var family2 = families.get(1)
			assertFamily(expectedFamily1, family1)
			assertFamily(expectedFamily2, family2)
		]
	}
	
	@Test
	def void testChangeGender_FatherToMotherBlocked(){
		createInsuranceDatabaseWithCompleteFamily()
		
		awaitReplacementInformation(fullName(FIRST_MOM_1, LAST_NAME_1), LAST_NAME_1)
		decideParentOrChild(PositionPreference.Parent)
		decideNewOrExistingFamily(FamilyPreference.New, 0)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_DAD_1, LAST_NAME_1).gender = Gender.FEMALE
			]
		]
		
		validateFamilyView [
			var expectedFamily1 = createFamily [
				lastName = LAST_NAME_1
				mother = createFamilyMember [ firstName = FIRST_DAD_1]
				sons += createFamilyMember [ firstName = FIRST_SON_1]
				daughters += createFamilyMember [ firstName = FIRST_DAU_1]
			]
			var expectedFamily2 = createFamily [
				lastName = LAST_NAME_1
				mother = createFamilyMember [ firstName = FIRST_MOM_1]
			]
			
			var families = claimFamilyRegister(it).families
			assertNumberOfFamilies(2)
			var family1 = families.get(0)
			var family2 = families.get(1)
			assertFamily(expectedFamily1, family1)
			assertFamily(expectedFamily2, family2)
		]
	}
	
	@Test
	def void testChangeName_firstName(){
		createInsuranceDatabaseWithCompleteFamily()
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_DAD_1, LAST_NAME_1).name = fullName(FIRST_DAD_2, LAST_NAME_1)
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_DAD_2]
					mother = createFamilyMember [ firstName = FIRST_MOM_1]
					sons += createFamilyMember [ firstName = FIRST_SON_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testChangeName_onlyMemberInFamily(){
		createInsuranceDataBaseWithOptionalCompleteFamily(false, false, true, false)
		
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_SON_1, LAST_NAME_1).name = fullName(FIRST_SON_1, LAST_NAME_2)
			]
		]
		
		validateFamilyView [
			var expectedFamily = createFamily [
					lastName = LAST_NAME_2
					sons += createFamilyMember [ firstName = FIRST_SON_1]
				]
			assertNumberOfFamilies(1)
			val family = claimFamily(defaultFamilyRegister, LAST_NAME_2)
			assertFamily(expectedFamily, family)
		]
	}
	
	@Test
	def void testChangeName_newFamilyAsParent(){
		createInsuranceDatabaseWithCompleteFamily()
		
		decideParentOrChild(PositionPreference.Parent)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_SON_1, LAST_NAME_1).name = fullName(FIRST_SON_1, LAST_NAME_2)
			]
		]
		
		validateFamilyView [
			var expectedFamily1 =  createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_DAD_1]
					mother = createFamilyMember [ firstName = FIRST_MOM_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			var expectedFamily2 =  createFamily [
					lastName = LAST_NAME_2
					father = createFamilyMember [ firstName = FIRST_SON_1]
				]
			assertNumberOfFamilies(2)
			val family1 = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily1, family1)
			val family2 = claimFamily(defaultFamilyRegister, LAST_NAME_2)
			assertFamily(expectedFamily2, family2)
		]
	}
	
	@Test
	def void testChangeName_newFamilyAsChild(){
		createInsuranceDatabaseWithCompleteFamily()
		
		decideParentOrChild(PositionPreference.Child)
		changeInsuranceView [
			claimInsuranceDatabase(it) => [
				claimInsuranceClient(it, FIRST_SON_1, LAST_NAME_1).name = fullName(FIRST_SON_1, LAST_NAME_2)
			]
		]
		
		validateFamilyView [
			var expectedFamily1 =  createFamily [
					lastName = LAST_NAME_1
					father = createFamilyMember [ firstName = FIRST_DAD_1]
					mother = createFamilyMember [ firstName = FIRST_MOM_1]
					daughters += createFamilyMember [ firstName = FIRST_DAU_1]
				]
			var expectedFamily2 =  createFamily [
					lastName = LAST_NAME_2
					sons += createFamilyMember [ firstName = FIRST_SON_1]
				]
			assertNumberOfFamilies(2)
			val family1 = claimFamily(defaultFamilyRegister, LAST_NAME_1)
			assertFamily(expectedFamily1, family1)
			val family2 = claimFamily(defaultFamilyRegister, LAST_NAME_2)
			assertFamily(expectedFamily2, family2)
		]
	}
}