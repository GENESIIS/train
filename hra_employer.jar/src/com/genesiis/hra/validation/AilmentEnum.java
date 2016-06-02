package com.genesiis.hra.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Load ailment (deseases) to the Medical history form
 *  * @author @tr - thumeera
 * **/

public enum AilmentEnum {

	OTHERSURGERY("Other Surgery"),
	CARDIACSURGERY("Cardiac Surgery"),
	ORTHOPAEDICSURGERY("Orthopaedic Surgery"),

	CHICHENPOX("Chicken pox or shingles"),
	MEASLES("Measles"),
	MUMPS("Mumps"),
	SKINPROBLEM("Skin problems or chronic rash"),
	EYEPROBLEM("Eye problems"),
	HEARINGLOSS("Hearing loss or ear problems"),
	CHRONICCOUGH("Chronic cough"),
	ASTHMA("Asthma"),
	SHORTNESS("Shortness of breath"),
	LUNGPROBLEM("Lung problems"),
	TUBURCULOSIS("Tuberculosis or positive TB skin test"),
	CHESTPAIN("Chest pain"),
	HEARTTROUBLE("Heart trouble/attack"),
	PALPITATIONS("Palpitations/irregular heart beat"),
	HEARMUMUR("Heart murmur"),
	HIGHBLOODPRESSURE("High blood pressure"),
	STROKE("Stroke or paralysis"),
	STOMACHINTESTINALPROBLEM("Stomach or intestinal problem"),
	LIVERDISEASE("Liver disease/hepatitis"),
	KIDNEYDESEASE("Kidney disease"),
	WEIGHTCHANGE("Weight change"),
	THYROID("Thyroid problems"),
	SHOULDER("Shoulder/elbow/wrist/hand pain"),
	NUMBNESSARMS("Numbness/tingling of arms or hands "),
	BROKENBONES("Broken bones"),
	BONEJOINT("Bone or joint problems"),
	ARTHRITIS("Arthritis/gout"),
	BACKPAIN("Back pain/injury"),
	NUMBNESSLEGS("Numbness/tingling legs or feet"),
	KNEEPAIN("Knee pain/injury"),
	FOOTPAIN("Foot pain/injury"),
	NECKPAIN("Neck pain/injury"),
	LOSSOFLIMB("Loss of limb"),
	SEVEREHEADACHES("Severe headaches"),
	DIZZINESS("Dizziness or fainting"),
	EPILEPSY("Epilepsy or seizures"),
	SEVEREWEAKNESS("Severe weakness or tiredness"),
	DEPRESSION("Depression or anxiety"),
	EMOTIONAL("Emotional or psychiatric problems"),
	DRUG("Drug or Alcohol dependency"),
	EATING("Eating disorder"),
	BLEEDING("Bleeding or blood disorder"),
	IMMUNE("Immune suppression"),
	CHRONIC("Chronic/recurrent infection"),
	TUMOURCANCER("Tumour/cancer"),
	ANAEMIA("Anaemia"),
	DIABETIC("Diabetic"),
	ANYOTHER("Any other illness not listed"),
	
	;
	private String key;

	AilmentEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	public List<String> getAilmentenum() {

		List<String> list = new ArrayList<String>();
		try {
			List<AilmentEnum> somethingList = 
					Arrays.asList(AilmentEnum.values());

			for (AilmentEnum dd : somethingList) {
				list.add(dd.getKey());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
