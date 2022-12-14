package de.tum.in.ase.eist;

import org.easymock.*;
import org.easymock.internal.matchers.Null;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {

    // TODO implement the tests

    @TestSubject
    private Discussion discussion = new Discussion();

    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;

    @Test
    void testComment() {

        int newSize = discussion.getNumberOfComments() + 1;
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);
        discussion.addComment(commentMock);
        assertEquals(newSize, discussion.getNumberOfComments());
        verify(commentMock);


    }

    @Test
    void testCommentIfSavingFails() {

        expect(commentMock.save()).andReturn(false);
        replay(commentMock);
        int newSize = discussion.getNumberOfComments();
        discussion.addComment(commentMock);
        assertEquals(newSize, discussion.getNumberOfComments());
        verify(commentMock);


    }

    @Test
    void testStartCourseDiscussion() {
        Student student = new Student("Emi", "Mano", LocalDate.parse("2002-06-09"), "Science", "Computer");
        expect(courseMock.isDiscussionAllowed(student)).andReturn(true);
        replay(courseMock);
        assertTrue(discussion.startCourseDiscussion(courseMock, student, "Eist group meeting"));
        assertEquals(courseMock, discussion.getCourse());
        assertEquals("Eist group meeting", discussion.getTopic());
        verify(courseMock);
    }
}
