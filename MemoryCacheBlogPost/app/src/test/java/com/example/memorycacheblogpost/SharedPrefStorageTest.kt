package com.example.memorycacheblogpost

import android.content.SharedPreferences
import com.google.gson.Gson
import org.junit.Assert.*
import org.junit.Test

class SharedPrefStorageTest {

    @Test
    fun test_write_and_read() {
        val test = SharedPrefStorage(MyTestPreferences(), Gson())
        test.storeAll(listOf(ListItem("vendor2")))

        val all = test.getAll()

        assertEquals("vendor2", all[0].vendorName)


    }

    class MyTestPreferences : SharedPreferences {
        private var editor = MyTestEdit()


        override fun contains(p0: String?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getBoolean(p0: String?, p1: Boolean): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun unregisterOnSharedPreferenceChangeListener(p0: SharedPreferences.OnSharedPreferenceChangeListener?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getInt(p0: String?, p1: Int): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getAll(): MutableMap<String, *> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun edit(): SharedPreferences.Editor {
            return editor
        }

        override fun getLong(p0: String?, p1: Long): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getFloat(p0: String?, p1: Float): Float {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getStringSet(p0: String?, p1: MutableSet<String>?): MutableSet<String> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun registerOnSharedPreferenceChangeListener(p0: SharedPreferences.OnSharedPreferenceChangeListener?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getString(p0: String?, p1: String?): String? {
            return editor.string
        }

        class MyTestEdit : SharedPreferences.Editor{
            public var string: String? = ""

            override fun clear(): SharedPreferences.Editor {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun putLong(p0: String?, p1: Long): SharedPreferences.Editor {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun putInt(p0: String?, p1: Int): SharedPreferences.Editor {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun remove(p0: String?): SharedPreferences.Editor {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun putBoolean(p0: String?, p1: Boolean): SharedPreferences.Editor {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun putStringSet(
                p0: String?,
                p1: MutableSet<String>?
            ): SharedPreferences.Editor {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun commit(): Boolean {
                return true
            }

            override fun putFloat(p0: String?, p1: Float): SharedPreferences.Editor {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun apply() {

            }

            override fun putString(p0: String?, p1: String?): SharedPreferences.Editor {
                string = p1
                return this
            }

        }



    }
}