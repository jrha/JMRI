package jmri.jmrix.lenz.swing.packetgen;

import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.Assume;
import org.netbeans.jemmy.operators.JFrameOperator;

/**
 * Tests for the jmri.jmrix.lenz.packetgen.PacketGenAction class
 *
 * @author Bob Jacobsen Copyright (c) 2001, 2002
 */
public class PacketGenActionTest {

    private jmri.jmrix.lenz.XNetSystemConnectionMemo memo = null;

    @Test
    public void testStringCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        PacketGenAction action = new PacketGenAction("XNet Test Action", memo);
        Assert.assertNotNull(action);
    }

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        PacketGenAction action = new PacketGenAction(memo);
        Assert.assertNotNull(action);
    }

    @Test
    public void testActionCreateAndFire() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        PacketGenAction action = new PacketGenAction("Generate XpressNet message", memo);
        action.actionPerformed(null);
        // wait for frame with the value of PacketGenFrameTitle (from the
        // resource bundle ) in title, case insensitive
        // first boolean is false for exact to allow substring to match
        // second boolean is false to all case insensitive match
        JFrame frame = JFrameOperator.waitJFrame(Bundle.getMessage("PacketGenFrameTitle"), false, false);
        Assert.assertNotNull(frame);
        // verify the action provided the expected frame class
        Assert.assertEquals(PacketGenFrame.class.getName(), frame.getClass().getName());
        frame.dispose();
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        jmri.util.JUnitUtil.resetProfileManager();

        jmri.jmrix.lenz.XNetInterfaceScaffold t = new jmri.jmrix.lenz.XNetInterfaceScaffold(new jmri.jmrix.lenz.LenzCommandStation());
        memo = new jmri.jmrix.lenz.XNetSystemConnectionMemo(t);
    }

    @AfterEach
    public void tearDown() {
        memo = null;
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
    }

}
