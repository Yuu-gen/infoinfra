package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import baseTypes.Rational;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.fileService.CycleException;
import generated.fileService.Directory;
import generated.fileService.Element;
import generated.fileService.File;
import generated.fileService.FileService;
import generated.fileService.commands.directory.Directory_getElements_Command;

class FileServiceTest{
	private Directory d1,d2;
	private File f1, f2;
	public FileServiceTest() throws PersistenceException, ConstraintViolation {
		FileService.getInstance();
		d1 = Directory.createFresh(Optional.of("d1"));
		d2 = Directory.createFresh(Optional.of("d2"));
		f1 = File.createFresh(Optional.of("f1"), Integer.valueOf(1));
		f2 = File.createFresh(Optional.of("f2"), Integer.valueOf(2));
	}
// ======== Contains =============	
@Test
	void test1() throws CycleException, ConstraintViolation {
		d1.addElement(f1);
		d1.addElement(d2);
		d2.addElement(f2);
//		assertTrue(....contains(...));
//		assertFalse(....contains(...));
	}
// ====== AddElement ==================
@Test
	void test2() throws CycleException, ConstraintViolation {
		d1.addElement(d2);
		try {
			d2.addElement(d1);
			fail("Cycle Exception nicht erkannt");
		} catch (CycleException e) {
			System.out.println(e.getMessage());
		}
	}
// ================ Commands ================================
@Test
	void test3() throws Exception {
		d1.addToElements(f1);
		d1.addToElements(d2);
		d2.addToElements(f2);
		Directory_getElements_Command dgec;
	}
}
